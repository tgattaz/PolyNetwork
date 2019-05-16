package com.polytech.polynet.business;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "story")
public class Story {

    public Story() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="content")
    private String content;

    @OneToMany
    @JoinColumn(name= "story_id")
    private List<Comment> commentaires;

    public Story(String content, List<Comment> commentaires) {
        this.content = content;
        this.commentaires = commentaires;
    }

    public Story(String content, List<Comment> commentaires, Long id) {
        this.content = content;
        this.commentaires = commentaires;
        this.id = id;
    }

    public Long getIdentifiant() {
        return id;
    }

    public void setIdentifiant(Long id) {
        this.id = id;
    }

    public Story(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Comment> commentaires) {
        this.commentaires = commentaires;
    }

    @Override
    public String toString() {
        return "Story{" +
                "content='" + content + '\'' +
                '}';
    }
}
