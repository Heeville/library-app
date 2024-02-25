package com.group.libraryapp.domain.book;

import com.group.libraryapp.dto.book.request.BookCreateRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByName(String name);
}
