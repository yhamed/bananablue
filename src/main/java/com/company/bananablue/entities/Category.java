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

    @Column(columnDefinition = "LONGTEXT")
    String description;
    @Column(columnDefinition = "LONGTEXT")
    String link;

    @Column(name="image1",columnDefinition = "LONGTEXT")
    String mainImage;

    @Column(name="image2",columnDefinition = "LONGTEXT")
    String image;

    @Column(name = "titreImage")
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

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitreImage() {
        return titreImage;
    }

    public void setTitreImage(String titreImage) {
        this.titreImage = titreImage;
    }
}
