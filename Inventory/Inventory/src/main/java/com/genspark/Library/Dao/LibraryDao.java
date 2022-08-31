package com.genspark.Library.Dao;

import com.genspark.Library.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryDao extends JpaRepository<Book, Integer> {
}
