package com.polytech.polynet.api;

import com.polytech.polynet.objects.Story;
import com.polytech.polynet.business.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/liste")
    public List<Story> liste() {
        return toDoService.fetchAll();
    }

    @PostMapping("/create")
    public List<Story> task(@RequestBody String content) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //on vérifie qu'on est bien connect
        String name = authentication.getName();

        return toDoService.fetchAll();
    }

}
