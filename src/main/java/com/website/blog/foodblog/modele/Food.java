package com.website.blog.foodblog.modele;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.Date;

@Entity
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int foodId;

    @Column(name = "titlehome")
    private String titleHome;

    @Column(name = "deschome")
    private String descHome;

    @Column(name = "titleblog")
    private String titleBlog;

    @Column(name = "descblogpart1")
    private String descBlogPart1;

    @Column(name = "descblogpart2")
    private String descBlogPart2;

    @Column(name = "descblogpart3")
    private String descBlogPart3;

    @Column(name = "image1")
    private String image1;

    @Column(name = "image2")
    private String image2;

    @Column(name = "date")
    private String date;

    @Column(name = "category")
    private String category;
}
