package org.angelalfaro.my_books.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    // A user can have multiple borrowed books
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Book> books;

}