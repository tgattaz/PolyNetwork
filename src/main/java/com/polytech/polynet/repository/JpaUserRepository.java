package com.polytech.polynet.repository;

import com.polytech.polynet.business.Authority;
import com.polytech.polynet.exceptions.NameTakenException;
import com.polytech.polynet.objects.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void register(User u) throws NameTakenException {
        if(entityManager.find(User.class, u.getUsername()) == null) {
            entityManager.persist(u);
        } else {
            throw new NameTakenException();
        }
    }

    public void save_Authority(Authority authority) {
        entityManager.persist(authority);
    }

}
