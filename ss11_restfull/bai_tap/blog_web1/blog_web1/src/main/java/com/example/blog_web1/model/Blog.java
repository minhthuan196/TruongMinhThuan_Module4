package com.example.blog_web1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "text")
    private String content;
    @Column(columnDefinition = "Datetime")
    private String postDate;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryBlog;
}
