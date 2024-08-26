package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int counter = index; counter < products.length - 1; counter++) {
            products[counter] = products[counter + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}

