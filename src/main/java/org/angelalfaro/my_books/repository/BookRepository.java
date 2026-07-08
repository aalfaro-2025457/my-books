package org.angelalfaro.my_books.repository;

import org.angelalfaro.my_books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByOwnerIdUser(Long userId);

}
