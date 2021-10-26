package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.repository.DomainUtils.*;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    @BeforeEach
    public void before() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);
    }

    @Test
    public void shouldSave() {
        repository.save(book3);
        Product[] all = repository.findAll();
        assertArrayEquals(new Product[]{book1, book2, phone1, phone2, book3}, all);
    }

    @Test
    public void shouldFindById() {
        Product byId = repository.findById(book2.getId());
        assertEquals(book2, byId);
    }

    @Test
    public void shouldRemoveByExistingId() {
        assertNotNull(repository.findById(book2.getId()));
        repository.removeById(book2.getId());
        assertNull(repository.findById(book2.getId()));
    }

    @Test
    public void shouldRemoveByNotExistingId(){
        int lengthBefore = repository.findAll().length;
        assertNull(repository.findById(book3.getId()));
        repository.removeById(book3.getId());
        assertNull(repository.findById(book3.getId()));
        assertEquals(lengthBefore, repository.findAll().length);
    }

}