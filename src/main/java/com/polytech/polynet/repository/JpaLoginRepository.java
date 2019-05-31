package com.polytech.polynet.repository;

import com.polytech.polynet.business.Authority;
import com.polytech.polynet.objects.User;

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

    public void save_Authority(Authority authority) {
        EntityManager.persist(authority);
    }

}
