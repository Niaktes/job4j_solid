package ru.job4j.breach.srp;

public class Product {

    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public Product rollOut() {
        return new Product("rolledDough");
    }

    public Product cut() {
        return new Product("cutted " + this.productName);
    }

}