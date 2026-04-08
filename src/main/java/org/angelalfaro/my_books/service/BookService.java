package org.angelalfaro.my_books.service;

import lombok.RequiredArgsConstructor;
import org.angelalfaro.my_books.entity.Book;
import org.angelalfaro.my_books.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        // Business logic to retrieve all registered books
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        // Business logic to persist a new book
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        // Business logic to remove a book by its ID
        bookRepository.deleteById(id);
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }
}