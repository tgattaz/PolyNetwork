package com.polytech.polynet.business;

import com.polytech.polynet.exceptions.NameTakenException;
import com.polytech.polynet.objects.User;
import com.polytech.polynet.repository.UserRepository;

public class LoginServiceImpl implements LoginService {
    private UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository){
       this.userRepository = userRepository;
    }

    public void register(User user1) throws NameTakenException{
        userRepository.register(user1);
    }

    public void register_Authority(Authority authority) {
        userRepository.save_Authority(authority);
    }

}
