package org.angelalfaro.my_books.controller;

import org.angelalfaro.my_books.entity.Book;
import org.angelalfaro.my_books.entity.User;
import org.angelalfaro.my_books.service.BookService;
import org.angelalfaro.my_books.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final UserService userService;

    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public String listBooks(@RequestParam Long userId, Model model) {
        // We pass the userId to the view to keep the "session" alive in links
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("userId", userId);
        return "books/list";
    }

    @GetMapping("/new")
    public String showAddForm(@RequestParam Long userId, Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("userId", userId);
        return "books/form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book, @RequestParam Long userId) {
        // Fetch the user and set it as the owner of the book
        User owner = userService.getUserById(userId);
        book.setOwner(owner);

        bookService.saveBook(book);
        return "redirect:/books?userId=" + userId;
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, @RequestParam Long userId) {
        bookService.deleteBook(id);
        return "redirect:/books?userId=" + userId;
    }
}
