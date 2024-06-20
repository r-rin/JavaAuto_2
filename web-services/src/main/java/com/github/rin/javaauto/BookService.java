package com.github.rin.javaauto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookService {
    private static BookService instance;

    private List<Book> books = new ArrayList<>();

    private BookService() {}

    public static BookService getInstance()
    {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(UUID uuid) {
        Book bookToDelete = findBookByUUID(uuid);

        if(bookToDelete != null)
        {
            books.remove(bookToDelete);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    private Book findBookByUUID(UUID uuid) {
        return books.stream()
                .filter(book -> book.getId().equals(uuid))
                .findFirst()
                .orElse(null);
    }
}
