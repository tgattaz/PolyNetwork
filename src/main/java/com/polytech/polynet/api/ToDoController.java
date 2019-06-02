package com.polytech.polynet.api;

import com.polytech.polynet.business.PublicationService;
import com.polytech.polynet.objects.Task;
import com.polytech.polynet.business.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private PublicationService publicationService;

    @GetMapping("/liste")
    public List liste() {
        return toDoService.fetchAll();
    }

    @PostMapping("/create")
    public List task(@RequestBody Task t) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        t.setUsername(authentication.getName());
        publicationService.share(t);
        return toDoService.fetchAll();
    }

    @PostMapping("/delete")
    public List delete_story(@RequestBody int id) {
        publicationService.delete_task(id);
        return toDoService.fetchAll();
    }

    @PostMapping("/update/{id_task}")
    public List update(@PathVariable("id_task") int id, @RequestBody String string) {
        publicationService.update(id, string);
        return toDoService.fetchAll();
    }

    @PostMapping("/done")
    public List done(@RequestBody int id) {
        publicationService.done(id);
        return toDoService.fetchAll();
    }
}
