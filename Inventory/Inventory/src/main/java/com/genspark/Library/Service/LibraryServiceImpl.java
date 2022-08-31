package com.genspark.Library.Service;

import com.genspark.Library.Dao.LibraryDao;
import com.genspark.Library.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDao libraryDao;

    @Override
    public List<Book> getLibrary() {
        return this.libraryDao.findAll();
    }

    @Override
    public Book getBookById(int bookId) {
        Optional<Book> b = this.libraryDao.findById(bookId);
        Book book = null;

        if (b.isPresent()) {
            book = b.get();
        } else {
            throw new RuntimeException(" Book not found for id :: " + bookId);
        }

        return book;
    }

    @Override
    public Book addBook(Book book) {
        return this.libraryDao.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return this.libraryDao.save(book);
    }

    @Override
    public String deleteBook(int bookId) {
        this.libraryDao.deleteById(bookId);
        return "Book deleted successfully";
    }

}
