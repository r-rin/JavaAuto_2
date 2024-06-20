package com.github.rin.javaauto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/books")
public class BookController {

    BookService bookService = BookService.getInstance();

    @GetMapping()
    public String getBooks(Model model){
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books-list";
    }

    @GetMapping("/create")
    public String getCreateBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "create-book";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam("id") UUID id) {
        bookService.removeBook(id);
        return "redirect:/books";
    }

}
