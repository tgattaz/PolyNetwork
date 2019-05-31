package com.polytech.polynet.business;

import com.polytech.polynet.objects.Story;

import java.util.List;

public interface ToDoService {
    List<Story> fetchAll();
}
