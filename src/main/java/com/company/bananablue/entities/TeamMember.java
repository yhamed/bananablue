package com.company.bananablue.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "banana_team")
public class TeamMember implements Serializable {
    public TeamMember() {

    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String firstName;
    String lastName;
    String poste;

    @Column(name="imageBase64",columnDefinition = "LONGTEXT")
    String image;

    @ManyToOne
    @JsonIgnore
    private Apropos apropos;

    String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Apropos getApropos() {
        return apropos;
    }

    public void setApropos(Apropos apropos) {
        this.apropos = apropos;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", poste='" + poste + '\'' +
                ", image='" + image + '\'' +
                ", apropos=" + apropos +
                ", description='" + description + '\'' +
                '}';
    }
}

