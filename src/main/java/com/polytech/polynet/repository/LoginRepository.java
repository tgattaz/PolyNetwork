package com.polytech.polynet.repository;

import com.polytech.polynet.business.Authority;
import com.polytech.polynet.objects.User;

public interface LoginRepository {

    void register(User user);

    void save_Authority(Authority authority);
}