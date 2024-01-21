package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void removingActualLastProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "яблоко", 100);
        Product product2 = new Product(2, "груша", 200);
        Product product3 = new Product(3, "банан", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removingActualMiddleProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "яблоко", 100);
        Product product2 = new Product(2, "груша", 200);
        Product product3 = new Product(3, "банан", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removingNotActualProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "яблоко", 100);
        Product product2 = new Product(2, "груша", 200);
        Product product3 = new Product(3, "банан", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(44));
    }
}




