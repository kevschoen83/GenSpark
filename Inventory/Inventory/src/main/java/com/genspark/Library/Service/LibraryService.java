package com.genspark.Library.Service;

import com.genspark.Library.Entity.Book;

import java.util.List;

public interface LibraryService {

    List<Book> getLibrary();
    Book getBookById(int bookId);
    Book addBook(Book book);
    Book updateBook(Book book);
    String deleteBook(int bookId);

}
