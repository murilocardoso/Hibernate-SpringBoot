package com.bookstore.service;

import com.bookstore.repository.AuthorRepository;
import com.bookstore.entity.Author;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookstoreService(AuthorRepository authorRepository,
            BookRepository bookRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void displayAuthorsAndBooks() {

        List<Author> authors = authorRepository.findAll();

        for (Author author : authors) {
            System.out.println("\nAuthor: " + author);
            System.out.println("No of books: "
                    + author.getBooks().size() + ", " + author.getBooks());
        }
    }

    public void displayBooksAndAuthors() {

        List<Book> books = bookRepository.findAll();

        for (Book book : books) {
            System.out.println("\nBook: " + book);
            System.out.println("Author: " + book.getAuthor());
        }
    }
}
