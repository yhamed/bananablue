package com.company.bananablue.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "home_grid")
public class GridHome implements Serializable {
public GridHome() {

}
@Id @GeneratedValue(strategy = GenerationType.AUTO)
Long id;
@Column(name = "title")
String titre;

@Column(columnDefinition = "LONGTEXT")
String content;

@Column(name="imageBase64",columnDefinition = "LONGTEXT")
String image;

@Column(columnDefinition = "LONGTEXT")
String link;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
