package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(5, "корм для кошек", 24);
    Product product2 = new Product(10, "хлеб", 56);
    Product product3 = new Product(634, "сосиски", 243);
    ShopRepository shop = new ShopRepository();

    void Initalizator() {
        shop.add(product1);
        shop.add(product2);
        shop.add(product3);
    }

    @Test
    public void checkingThrowingException() {
        Initalizator();
        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.remove(4);
        });
    }

    @Test

    public void checkingFindByIdMethodNegative() {
        Initalizator();
        Assertions.assertEquals(null, shop.findById(4));
    }

    public void checkingFindByIdMethod() {
        Initalizator();
        Assertions.assertEquals(product1, shop.findById(10));
    }
}
