package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.repository.DomainUtils.book1;

class BookTest {

    @Test
    void shouldMatcherByAuthor() {
        assertTrue(book1.matches("author1"));
    }

    @Test
    void shouldNotMatcherByAuthor() {
        assertFalse(book1.matches("asd"));
    }

    @Test
    void shouldMatcherByName() {
        assertTrue(book1.matches("book1"));
    }

    @Test
    void shouldNoMatcherByName() {
        assertFalse(book1.matches("dfghjk"));
    }
}