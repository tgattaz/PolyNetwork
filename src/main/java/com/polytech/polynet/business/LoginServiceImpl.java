package com.polytech.polynet.business;

import com.polytech.polynet.repository.LoginRepository;

public class LoginServiceImpl implements LoginService {
    private LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository){
       this.loginRepository = loginRepository;
    }

    public void register(User user1) {
        loginRepository.register(user1);
    }

    public void login(User user) {
        loginRepository.login(user);
    }
}
