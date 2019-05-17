package com.polytech.polynet.repository;

import com.polytech.polynet.business.User;
import com.polytech.polynet.repository.LoginRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class JpaLoginRepository implements LoginRepository {

    @PersistenceContext
    EntityManager EntityManager;

    public void register(User u) {
        EntityManager.persist(u);

    }
}
