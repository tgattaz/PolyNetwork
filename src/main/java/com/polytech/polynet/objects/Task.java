package com.polytech.polynet.objects;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "task")
public class Task {

    @Id
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "done")
    private boolean done;

    @Column(name = "date")
    private Date date;

    @Column(name = "username")
    private String username;

    public Task(int id, String username, String content) {
        this.id = id;
        this.content = content;
        this.done = false;
        this.username = username;
        this.date = new Date();
    }

    public Task(String content) {
        this.content = content;
        this.done = false;
    }

    public Task() {
        this.done = false;
    }

    public Date getDate() {
        return date;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Task {" +
                "id : " + id +
                ", content : '" + content +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
