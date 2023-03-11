package ru.job4j.ood.dip;

import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

public class SimpleShopService {

    /*
    private HashMap<User, Set<Order>> serviceDB = new HashMap<>(); - зависимость от реализации, а не от абстракции
    */
    private ShopStore shopStore;
    private OrderService orderService;
    private static final Logger LOGGER = Logger.getLogger("Shop logger");

    public SimpleShopService(ShopStore shopStore, OrderService orderService) {
        this.shopStore = shopStore;
        this.orderService = orderService;
    }

    /* реализация методов с HashMap переведена на интерфейс ShopStore */
    public boolean createBucket(User user) {
        if (shopStore.getUsers().contains(user)) {
            return false;
        }
        return shopStore.saveUser(user);
    }

    public boolean createOrder(User user, Order order) {
        Set<Order> orders = shopStore.getOrders(user);
        if (orders.isEmpty()) {
            return false;
        }
        return orders.add(order);
    }

    public boolean addProduct(User user, Order order, Product product) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            return false;
        }
        return orderDB.get().add(product);
    }

    private Optional<Order> findOrder(User user, Order order) {
        return shopStore.getOrders(user).stream()
                .filter(o -> o.getId() == order.getId())
                .findFirst();
    }

    public boolean removeProduct(User user, Order order, Product product) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            return false;
        }
        return orderDB.get().remove(product.getId());
    }

    public boolean removeOrder(User user, Order order) {
        Set<Order> orders = shopStore.getOrders(user);
        if (orders == null) {
            return false;
        }
        return orders.remove(order);
    }

    public Check payOrder(User user, Order order) {
        Optional<Order> orderDB = findOrder(user, order);
        if (orderDB.isEmpty()) {
            LOGGER.warning("Get error with " + user + " " + order);
            throw new IllegalArgumentException("Invalid order");
        }
        if (orderDB.get().isPayed()) {
            LOGGER.warning("Get error with " + user + " " + order);
            throw new IllegalArgumentException("Already payed!");
        }
        orderDB.get().setPayed(true);
        return new Check((int) (System.currentTimeMillis() % 1_000_000), "Payed: " + orderDB.get().getId());
    }

}