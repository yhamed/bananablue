package com.company.bananablue.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "carousel")
public class Carousel implements Serializable {

    public Carousel() {

    }
    @Id
    Long id;
    @Column(name = "title")
    String titre;

    @OneToMany(mappedBy = "carousel")
    List<CarouselEntry> items;

    String footer;
    String description;

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

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CarouselEntry> getItems() {
        return items;
    }

    public void setItems(List<CarouselEntry> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", items=" + items +
                ", footer='" + footer + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
