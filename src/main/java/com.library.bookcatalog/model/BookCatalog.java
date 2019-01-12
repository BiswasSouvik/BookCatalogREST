package com.library.bookcatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.Id;

@JsonSerialize(as = BookCatalog.class)
@JsonDeserialize(as = BookCatalog.class)
@JsonIgnoreProperties(ignoreUnknown=true)
public class BookCatalog {
    @Id
    private String bookId;
    private String bookName;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
