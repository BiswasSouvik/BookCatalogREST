package com.library.bookcatalog.service;

import com.library.bookcatalog.model.BookCatalog;

import java.util.List;

public interface BookCatalogService {
    void addBookCatalog(BookCatalog bookCatalog);

    List<BookCatalog> listBookCatalog();

    BookCatalog getBookCatalog(String bookId);

    void deleteBookCatalog(BookCatalog bookCatalog);

    BookCatalog updateBookCatalog(BookCatalog bookCatalog);
}
