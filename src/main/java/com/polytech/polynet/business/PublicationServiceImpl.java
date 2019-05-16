package com.polytech.polynet.business;

import com.polytech.polynet.repository.StoryRepository;

public class PublicationServiceImpl implements PublicationService {

    private StoryRepository storyRepository;

    public PublicationServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void share(Story story1) {
       storyRepository.save(story1);
    }

    public void comment(Comment comment1) {
        storyRepository.save_com(comment1);
    }
}
