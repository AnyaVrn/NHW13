package org.example;

import lombok.Data;

@Data

public class Product {
    protected int id;
    protected String name;

    private int price;

    public boolean matches(String search) {
        return this.getName().contains(search);

    }
}