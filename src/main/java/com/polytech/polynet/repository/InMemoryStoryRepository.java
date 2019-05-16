package com.polytech.polynet.repository;

import com.polytech.polynet.business.Comment;
import com.polytech.polynet.business.Story;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStoryRepository implements StoryRepository {

    private List<Story> stories = new ArrayList<Story>();

    public List<Story> findAll() {
        return stories;
    }


    public void save(Story story){
        stories.add(story);
    }

    public List<Comment> comment_findAll(long id) { return null;};

    public void save_com(Comment comment) {};
}
