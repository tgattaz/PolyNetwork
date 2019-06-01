package com.polytech.polynet.repository;

import com.polytech.polynet.objects.Task;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaToDoRepository implements ToDoRepository {

    private static String requeteFindTask = "SELECT t FROM Task t WHERE t.username = ";
    @PersistenceContext
    EntityManager entityManager;

    public List save(Task t) {
        entityManager.persist(t);
        return this.findAll();
    }

    public List findAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Query query = entityManager.createQuery( requeteFindTask + "'" + authentication.getName() + "'");
        return query.getResultList();
    }

    public List delete(int id) {
       entityManager.remove(entityManager.find(Task.class, id));
       return this.findAll();
    }

    public List modif(int id, String s) {
        entityManager.find(Task.class, id).setContent(s);
        return this.findAll();
    }

    public List done(int id) {
        Task t = entityManager.find(Task.class, id);
        t.setDone(!t.getDone());
        return this.findAll();
    }
}
