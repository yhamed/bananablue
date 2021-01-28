package com.company.bananablue.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FAQ")
public class Faq implements Serializable {
    public Faq() {

    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nom;
    String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
