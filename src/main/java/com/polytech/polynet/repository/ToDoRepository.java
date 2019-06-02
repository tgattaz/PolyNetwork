package com.polytech.polynet.repository;

import com.polytech.polynet.objects.Task;

import java.util.List;

public interface ToDoRepository {

    List findAll();

    List save(Task task);

    List delete(int id);

    List update(int id, String s);

    List done(int id);
}
