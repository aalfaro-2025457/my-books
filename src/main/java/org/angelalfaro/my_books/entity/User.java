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
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    // A user can have multiple borrowed books
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Book> books;

}