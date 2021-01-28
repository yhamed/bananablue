package com.company.bananablue.entities;

import javax.persistence.*;

@Entity
@Table(name = "catagories")
public class Category {
    public Category() {

    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "title")
    String titre;

    String description;
    String link;
    @Column(name="ThumbnailImageBase64")
    String thumbnail;

    @Column(name = "thumbnailTitle")
    String titreImage;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitreImage() {
        return titreImage;
    }

    public void setTitreImage(String titreImage) {
        this.titreImage = titreImage;
    }
}
