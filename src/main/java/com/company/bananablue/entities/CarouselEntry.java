package com.company.bananablue.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "carousel_item")
public class CarouselEntry  implements Serializable {
    public CarouselEntry() {
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="imageBase64",columnDefinition = "LONGTEXT")
    String image;

    String titre;

    @Column(columnDefinition = "LONGTEXT")
    String url;

    @Column(columnDefinition = "LONGTEXT")
    String description;

    @ManyToOne
    @JsonIgnore
    Carousel carousel;

    @Column(name="floatV")
    String verticalPosition = "top";
    @Column(name="floatH")
    String horizantalPosition = "left";

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Carousel getCarousel() {
        return carousel;
    }

    public void setCarousel(Carousel carousel) {
        this.carousel = carousel;
    }

    public String getVerticalPosition() {
        return verticalPosition;
    }

    public void setVerticalPosition(String verticalPosition) {
        this.verticalPosition = verticalPosition;
    }

    public String getHorizantalPosition() {
        return horizantalPosition;
    }

    public void setHorizantalPosition(String horizantalPosition) {
        this.horizantalPosition = horizantalPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
