package com.polytech.polynet.repository;

import com.polytech.polynet.business.Authority;
import com.polytech.polynet.exceptions.NameTakenException;
import com.polytech.polynet.objects.User;

public interface UserRepository {

    void register(User user) throws NameTakenException;

    void save_Authority(Authority authority);
}