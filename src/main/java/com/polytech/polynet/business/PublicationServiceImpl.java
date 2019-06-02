package com.polytech.polynet.business;

import com.polytech.polynet.objects.Task;
import com.polytech.polynet.repository.ToDoRepository;

public class PublicationServiceImpl implements PublicationService {

    private ToDoRepository toDoRepository;

    public PublicationServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public void share(Task task) {
       toDoRepository.save(task);
    }

    public void delete_task(int id) {
        toDoRepository.delete(id);
    }

    public void done(int id) {
        toDoRepository.done(id);
    }

    public void modif(int id, String s) {
        toDoRepository.modif(id, s);
    }

}
