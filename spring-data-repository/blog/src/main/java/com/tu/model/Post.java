package com.tu.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(name = "content", length = 25000)
    private String Content;
    @Column(name = "image", length = 3000000)
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private boolean deleted;
}
