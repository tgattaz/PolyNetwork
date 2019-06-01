package com.polytech.polynet.business;


import com.polytech.polynet.repository.ToDoRepository;

import java.util.List;

public class ToDoServiceImpl implements ToDoService {
    private ToDoRepository toDoRepository;

    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List fetchAll() {
        return toDoRepository.findAll();
    }
}
