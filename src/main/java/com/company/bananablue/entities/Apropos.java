package com.company.bananablue.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "about_us")
public class Apropos implements Serializable {
    public Apropos() {

    }
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "title")
    String titre;

    @Column(columnDefinition = "LONGTEXT")
    String content;

    @OneToMany(mappedBy = "apropos")
    List<TeamMember> memberList;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<TeamMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<TeamMember> memberList) {
        this.memberList = memberList;
    }
}
