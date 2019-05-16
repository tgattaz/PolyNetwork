package com.polytech.polynet.business;

import com.polytech.polynet.repository.InMemoryStoryRepository;
import com.polytech.polynet.repository.StoryRepository;

import java.util.HashMap;
import java.util.Map;

public class MyObjectFactory {

    private Map<Class, Object> map = new HashMap<Class, Object>();

    public MyObjectFactory(){
        InMemoryStoryRepository storyRepository = new InMemoryStoryRepository();
        map.put(StoryRepository.class, storyRepository);
        map.put(PublicationService.class, new PublicationServiceImpl(storyRepository));
    }

    public <T> T getByType(Class<T> classZ) {
        return (T) map.get(classZ);
    }

}
