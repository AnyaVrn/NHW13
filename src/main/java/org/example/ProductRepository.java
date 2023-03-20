package org.example;
import org.example.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll(){
        return  products;
    }

    public void save(Product newProduct) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newProduct;

        products = tmp;
    }

    public void deleteById(int removeId) {
        if (products.length != 0) {
            Product[] tmp = new Product[products.length - 1];
            int index = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[i].getId() != removeId) {
                    if (index + 1 == products.length) {
                        return;
                    }
                    tmp[index] = products[i];
                    index++;
                }
            }

            products = tmp;
        }
    }

}