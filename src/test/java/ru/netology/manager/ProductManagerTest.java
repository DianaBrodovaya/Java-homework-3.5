package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Product;
import ru.netology.repository.DomainUtils;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static ru.netology.repository.DomainUtils.*;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductManager productManager;

    @Test
    public void shouldAdd() {
        productManager.add(book3);
        Mockito.verify(productRepository).save(book3);
    }

    @Test
    public void shouldSearchByProductNotUniqueName() {
        Mockito.doReturn(DomainUtils.defaultProducts).when(productRepository).findAll();
        Product[] products = productManager.searchBy("book");
        assertArrayEquals(new Product[]{book1, book2}, products);
    }

    @Test
    public void shouldSearchByProductUniqueName() {
        Mockito.doReturn(DomainUtils.defaultProducts).when(productRepository).findAll();
        Product[] products = productManager.searchBy("book1");
        assertArrayEquals(new Product[]{book1}, products);
    }

    @Test
    public void shouldSearchByProductUniqueAuthor() {
        Mockito.doReturn(DomainUtils.defaultProducts).when(productRepository).findAll();
        Product[] products = productManager.searchBy("author1");
        assertArrayEquals(new Product[]{book1}, products);
    }

    @Test
    public void shouldSearchByProductNotUniqueAuthor() {
        Mockito.doReturn(DomainUtils.defaultProducts).when(productRepository).findAll();
        Product[] products = productManager.searchBy("author");
        assertArrayEquals(new Product[]{book1, book2}, products);
    }

    @Test
    public void shouldSearchByProductNotUniqueManufacturer() {
        Mockito.doReturn(DomainUtils.defaultProducts).when(productRepository).findAll();
        Product[] products = productManager.searchBy("manufacturer");
        assertArrayEquals(new Product[]{phone1, phone2}, products);
    }

    @Test
    public void shouldSearchByProductUniqueManufacturer() {
        Mockito.doReturn(DomainUtils.defaultProducts).when(productRepository).findAll();
        Product[] products = productManager.searchBy("manufacturer1");
        assertArrayEquals(new Product[]{phone1}, products);
    }

    @Test
    public void shouldSearchByEmptyString() {
        Product[] products = productManager.searchBy("");
        assertArrayEquals(new Product[]{}, products);
    }

    @Test
    public void shouldSearchByNullString() {
        Product[] products = productManager.searchBy(null);
        assertArrayEquals(new Product[]{}, products);
    }

    @Test
    public void shouldSearchByWrongString() {
        Mockito.doReturn(DomainUtils.defaultProducts).when(productRepository).findAll();
        Product[] products = productManager.searchBy(" gy7nbvt6");
        assertArrayEquals(new Product[]{}, products);
    }

}