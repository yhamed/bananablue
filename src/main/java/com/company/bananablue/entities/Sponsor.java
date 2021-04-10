package com.company.bananablue.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "sponsors")
public class Sponsor implements Serializable {
    public Sponsor() {

    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nom;
    @Column(name="imageBase64",columnDefinition = "LONGTEXT")
    String image;

    @Column(columnDefinition = "LONGTEXT")
    String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
