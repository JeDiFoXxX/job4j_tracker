package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int arrayIndex = 0; arrayIndex < products.length; arrayIndex++) {
            if (products[arrayIndex] == null) {
                for (int counter = arrayIndex; counter < products.length - 1; counter++) {
                    products[counter] = products[counter + 1];
                }
            }
        }
        products[products.length - 1] = null;
        return products;
    }
}

