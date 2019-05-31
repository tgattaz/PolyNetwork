package com.polytech.polynet.business;

import com.polytech.polynet.objects.Story;
import com.polytech.polynet.repository.StoryRepository;

import java.util.List;

public class ToDoServiceImpl implements ToDoService {
    private StoryRepository storyRepository;

    public ToDoServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public List<Story> fetchAll() {
        return storyRepository.findAll();
    }
}
