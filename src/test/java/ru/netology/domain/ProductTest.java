package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.DomainUtils;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldMatcher() {
        assertTrue(DomainUtils.product.matches("product1"));
    }
    @Test
    void shouldNotMatcher() {
        assertFalse(DomainUtils.product.matches("dfgh"));
    }

}