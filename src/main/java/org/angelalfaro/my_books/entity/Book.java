package org.angelalfaro.my_books.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String author;

    // Field for the book cover image URL
    @Column
    private String coverUrl;

    @ManyToOne
    @JoinColumn(name = "idUser", foreignKey = @ForeignKey(name = "FK_user"))
    private User owner;
}
