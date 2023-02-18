package ru.job4j.breach.srp;

import java.util.ArrayList;
import java.util.List;

public class PizzaCook implements Cook {

    List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public void chopProducts() {

    }

    @Override
    public void cookProducts() {
        getProducts();
        chopProducts();
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase("dough")) {
                product.rollOut();
            }
        }
    }

    @Override
    public void serveFood() {

    }
}

/*
В данном случае я вижу нарушение сразу нескольких принципов. Например, нарушение инверсии зависимостей, ведь в данном случае повар берёт продукты сам, хотя правильнее было бы, чтобы продукты ему подавали.
Помимо этого:
 повар берёт продукты, хотя правильнее было бы, чтобы был некто Supplyer, который уже возьмет продукты из холодильника или из коробки, и подаст их повару;
 повар режет продукты, хотя правильнее было бы, чтобы был некто Cutter, который порежет продукты кубиками, или соломкой, или их вообще не потребуется резать перед готовкой;
 повар серверует еду перед подачей, хотя одно дело подать еду на тарелке дома, сервировать красиво в ресторане, или вообще есть руками со сковородки, без всякой сервировки, соответственно реализаций сервировки может быть море.
Также следовало бы выделить Product в интерфейс и выделить в нём метод "приготовить", потому что у меня сейчас там и метод для теста (раскатать), и метод для иных продуктов (порезать).
*/