package org.example;


import org.example.Product;
import org.example.ProductRepository;

public class ProductManager {

    private ProductRepository repository = new ProductRepository();

    public void add(Product product){
        repository.save(product);
    }

    public Product[] findAll(){
        return repository.findAll();
    }

    public void deleteById(int removeProductId){
        repository.deleteById(removeProductId);
    }

    public boolean matches(Product product, String search) {
        return product.matches(search);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {

                int length = result.length + 1;
                Product[] tmp = new Product[length];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;

                result = tmp;
            }
        }
        return result;
    }

}