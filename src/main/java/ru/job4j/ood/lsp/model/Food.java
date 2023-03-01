package ru.job4j.ood.lsp.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Food {

    private final String name;
    private final LocalDateTime expiryDate;
    private final LocalDateTime createDate;
    private double price;
    private int discount;

    public Food(String name, LocalDateTime expiryDate, LocalDateTime createDate, double price, int discount) {
        if (createDate.isAfter(expiryDate)) {
            throw new IllegalArgumentException("Wrong pair of expiry date and create date");
        }
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        if (Double.compare(food.price, price) != 0) {
            return false;
        }
        if (discount != food.discount) {
            return false;
        }
        if (!Objects.equals(name, food.name)) {
            return false;
        }
        if (!Objects.equals(expiryDate, food.expiryDate)) {
            return false;
        }
        return Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        long temp;
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + discount;
        return result;
    }

}