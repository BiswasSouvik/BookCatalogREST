package com.library.bookcatalog.controller;

import com.library.bookcatalog.model.BookCatalog;
import com.library.bookcatalog.service.BookCatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookcatalog")
class BookCatalogController {
    private static final Logger logger = LoggerFactory.getLogger(BookCatalogController.class);

    @Autowired
    private BookCatalogService bookCatalogService;

    BookCatalogController(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    ResponseEntity<List<BookCatalog>> findAll() {
        logger.debug("findAll : init request findAll");
        return new ResponseEntity<>(bookCatalogService.listBookCatalog(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    ResponseEntity<BookCatalog> find(@PathVariable("id") String id) {
        logger.debug("find : init request find");
        return new ResponseEntity<>(bookCatalogService.getBookCatalog(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    ResponseEntity<BookCatalog> updateBookCatalog(@RequestBody BookCatalog bookCatalog) {
        logger.debug("updateBookCatalog : init request updateBookCatalog");
        return new ResponseEntity<>(bookCatalogService.updateBookCatalog(bookCatalog), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    ResponseEntity<BookCatalog> add(@RequestBody BookCatalog bookCatalog) throws Exception {
        logger.debug("add : init request add");
        BookCatalog temp = bookCatalogService.getBookCatalog(bookCatalog.getBookId());
        if (temp != null) {
            throw new Exception("BookCatalog already exists");
        } else {
            bookCatalogService.addBookCatalog(bookCatalog);
            return new ResponseEntity<>(bookCatalog, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
    void delete(@PathVariable("id") String id) throws Exception {
        logger.debug("delete : init request delete");
        BookCatalog temp = bookCatalogService.getBookCatalog(id);
        if (temp == null) {
            throw new Exception("BookCatalog doesnot exists");
        } else {
            bookCatalogService.deleteBookCatalog(bookCatalogService.getBookCatalog(id));
        }
    }
}
