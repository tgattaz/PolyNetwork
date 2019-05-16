package com.polytech.polynet.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

    @Column(name ="content")
    private String content;

    @Column(name = "story_id")
    private String identifiant;

    @Id
    @Column(name="id")
    private int id;

    public Comment() {}

    public Comment(String content, String identifiant) {
        this.content = content;
        this.identifiant = identifiant;
    }

    public Comment(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Override
    public String toString() {
        return "Commnent{" +
                "content='" + this.content + '\'' +
                "Id_Story='" + this.identifiant + '\'' +
                '}';
    }
}
