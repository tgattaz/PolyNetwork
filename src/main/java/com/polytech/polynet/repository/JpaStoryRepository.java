package com.polytech.polynet.repository;


import com.polytech.polynet.business.Comment;
import com.polytech.polynet.objects.Story;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;
import java.util.List;

@Transactional
public class JpaStoryRepository implements StoryRepository {

    @PersistenceContext
    EntityManager EntityManager;



    public void save(Story s) {
        EntityManager.persist(s);
    }

    public void save_com(Comment c) {
        EntityManager.persist(c);
    }

    private String requeteFindStory = "SELECT s from Story s";

    public List findAll() {
        Query query = EntityManager.createQuery(requeteFindStory);
        return query.getResultList();
    }

    public List<Comment> comment_findAll(long id) {
        return null;
    }
}
