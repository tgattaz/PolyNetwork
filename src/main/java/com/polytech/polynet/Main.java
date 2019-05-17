package com.polytech.polynet;

import com.polytech.polynet.business.Story;
import com.polytech.polynet.config.AppConfig;
import com.polytech.polynet.repository.StoryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AppConfig.class);
        StoryRepository storyRepository = context.getBean(StoryRepository.class);
        storyRepository.
                save(new Story("MARSEILLE"));
        storyRepository.save(new Story("PARIS"));
        storyRepository.save(new Story("NY"));
        storyRepository.save(new Story("LONDON"));

        List<Story> stories = storyRepository.findAll();
        for (Story story : stories) {
            System.out.println(story.toString());
        }
    }
}