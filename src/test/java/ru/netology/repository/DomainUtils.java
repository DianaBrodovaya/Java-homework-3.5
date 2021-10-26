package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class DomainUtils {

    public static final Product product = new Product(10, "product1", 987654321);
    public static final Book book1 = new Book(1, "book1", 123, "author1");
    public static final Book book2 = new Book(2, "book2", 321, "author2");
    public static final Book book3 = new Book(3, "book3", 789, "author3");
    public static final Smartphone phone1 = new Smartphone(4, "Phone1", 9000, "manufacturer1");
    public static final Smartphone phone2 = new Smartphone(5, "Phone2", 5000, "manufacturer2");

    public static final Product[] defaultProducts = new Product[]{book1, book2, phone1, phone2, product};
}
