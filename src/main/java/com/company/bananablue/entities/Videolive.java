package com.company.bananablue.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "live_stream")
public class Videolive implements Serializable {

    public Videolive() {

    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(columnDefinition = "LONGTEXT")
    String linkYoutube;

    Date startTime;
    Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
