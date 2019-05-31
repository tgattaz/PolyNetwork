package com.polytech.polynet.api;

import com.polytech.polynet.business.Authority;
import com.polytech.polynet.business.LoginService;
import com.polytech.polynet.objects.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        user.setEnabled(true);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        loginService.register(user);
        Authority authority = new Authority(user.getUsername(), "admin");
        loginService.register_Authority(authority);
    }


}
