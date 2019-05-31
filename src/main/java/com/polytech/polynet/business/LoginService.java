package com.polytech.polynet.business;

import com.polytech.polynet.objects.User;

public interface LoginService {

    void register(User user);

    void register_Authority(Authority authority);
}
