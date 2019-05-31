package com.polytech.polynet.api;

import com.polytech.polynet.business.LoginService;
import com.polytech.polynet.business.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        loginService.register(user);
    }

    @PostMapping("/login")
    public void login(@RequestBody User user) {
        loginService.login(user);
    }

}
