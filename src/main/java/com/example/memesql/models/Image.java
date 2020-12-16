package com.example.memesql.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlSmall;
    private String urlMedium;
    private String urlBig;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ID_MEME", nullable = true)
    private Meme meme;

    public Image(@JsonProperty("id") Long id,
                 @JsonProperty("name") String name,
                 @JsonProperty("urlSmall") String urlSmall,
                 @JsonProperty("urlMedium") String urlMedium,
                 @JsonProperty("urlBig") String urlBig,
                 @JsonProperty("meme") Meme meme) {
        this.id = id;
        this.name = name;
        this.urlSmall = urlSmall;
        this.urlMedium = urlMedium;
        this.urlBig = urlBig;
        this.meme = meme;
    }

    public Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlSmall() {
        return urlSmall;
    }

    public void setUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
    }

    public String getUrlMedium() {
        return urlMedium;
    }

    public void setUrlMedium(String urlMedium) {
        this.urlMedium = urlMedium;
    }

    public String getUrlBig() {
        return urlBig;
    }

    public void setUrlBig(String urlBig) {
        this.urlBig = urlBig;
    }

}
