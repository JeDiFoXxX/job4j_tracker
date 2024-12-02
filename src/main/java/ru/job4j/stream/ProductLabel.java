package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> product.standard() - product.actual() >= 0)
                .filter(product -> product.standard() - product.actual() <= 3)
                .map(product -> new Label(product.name(), product.price() * 50 / 100).toString())
                .collect(Collectors.toList());
    }
}
