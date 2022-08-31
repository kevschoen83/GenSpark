package com.genspark.Library.Controller;

import com.genspark.Library.Entity.Book;
import com.genspark.Library.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to the Library Application</H1></HTML>";
    }

    @GetMapping("/library")
    public List<Book> getLibrary() {
        return this.libraryService.getLibrary();
    }

    @GetMapping("/library/{bookId}")
    public Book getBook(@PathVariable String bookId) {
        return this.libraryService.getBookById(Integer.parseInt(bookId));
    }

    @PostMapping("/library")
    public Book addBook(@RequestBody Book book) {
        return this.libraryService.addBook(book);
    }

    @PutMapping("/library")
    public Book updateBook(@RequestBody Book book) {
        return this.libraryService.updateBook(book);
    }

    @DeleteMapping("/library/{bookId}")
    public String deleteBook(@PathVariable String bookId) {
        return this.libraryService.deleteBook(Integer.parseInt(bookId));
    }

}
