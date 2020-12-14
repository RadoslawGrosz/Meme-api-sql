package com.example.memesql.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity()
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_IMAGE")
    private Image image;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_USER")
    private User user;

    public Meme(@JsonProperty("id") Long id,
                @JsonProperty("title") String title,
                @JsonProperty("description") String description,
                @JsonProperty("image") Image image,
                @JsonProperty("user") User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.user = user;
    }

    public Meme() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
