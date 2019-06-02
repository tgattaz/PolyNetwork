package com.polytech.polynet.business;

import com.polytech.polynet.exceptions.NameTakenException;
import com.polytech.polynet.objects.User;

public interface LoginService {
    void register(User user) throws NameTakenException;

    void register_Authority(Authority authority);
}
