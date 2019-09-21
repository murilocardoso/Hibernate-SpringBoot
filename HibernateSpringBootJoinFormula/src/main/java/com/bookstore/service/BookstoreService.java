package com.bookstore.service;

import com.bookstore.repository.BookRepository;
import com.bookstore.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookstoreService {

    private final BookRepository bookRepository;

    public BookstoreService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public void fetchBooks() {

        Book book = bookRepository.findById(4L).orElseThrow();
        Book prevBook = book.getPrevBook();

        System.out.println("Fetched book with id 4: " + book);
        System.out.println("Fetched book with next smallest price: " + prevBook);
    }
}
