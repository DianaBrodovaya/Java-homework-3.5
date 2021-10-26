package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.repository.DomainUtils.phone1;

class SmartphoneTest {

    @Test
    void shouldMatcherByManufacturer() {
        assertTrue(phone1.matches("manufacturer1"));
    }

    @Test
    void shouldNotMatcherByManufacturer() {
        assertFalse(phone1.matches("asd"));
    }

    @Test
    void shouldMatcherByName() {
        assertTrue(phone1.matches("Phone1"));
    }

    @Test
    void shouldNoMatcherByName() {
        assertFalse(phone1.matches("dfghjk"));
    }
}