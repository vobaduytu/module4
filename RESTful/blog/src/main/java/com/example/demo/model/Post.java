package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
