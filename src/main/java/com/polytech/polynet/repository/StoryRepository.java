package com.polytech.polynet.repository;

import com.polytech.polynet.business.Comment;
import com.polytech.polynet.objects.Story;

import java.util.List;

public interface StoryRepository {

    void save(Story s);
    void save_com(Comment c);
    List findAll();
    List<Comment> comment_findAll(long id);

}
