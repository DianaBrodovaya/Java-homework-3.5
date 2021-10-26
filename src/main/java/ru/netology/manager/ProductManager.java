package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

@AllArgsConstructor
public class ProductManager {
    private ProductRepository repository;

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        if (text == null || text.equals("")) {
            return new Product[0];
        }
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    private boolean matches(Product product, String text) {
        if (product.getName().contains(text)) {
            return true;
        } else {
            if (product instanceof Book) {
                return ((Book) product).getAuthor().contains(text);
            }
            if (product instanceof Smartphone) {
                return ((Smartphone) product).getManufacturer().contains(text);
            }
        }
        return false;
    }
}
