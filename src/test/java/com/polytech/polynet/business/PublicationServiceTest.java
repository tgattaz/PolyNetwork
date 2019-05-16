package com.polytech.polynet.business;

import com.polytech.polynet.AppConfig;
import com.polytech.polynet.repository.StoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import static java.util.Arrays.asList;

public class PublicationServiceTest {

    MyObjectFactory myObjectFactory = new MyObjectFactory();

    @Test
    public void should_save_story() {

        //Méthode 1 - SpringBoot qui sert de FactoryMethod

        ApplicationContext context = SpringApplication.run(AppConfig.class);
        StoryRepository storyRepository = context.getBean(StoryRepository.class);
        PublicationService publicationService = context.getBean(PublicationService.class);

        //Méthode 2 - Design Pattern FactoryMethod

        //GIVEN
        //StoryRepository storyRepository = myObjectFactory.getByType(StoryRepository.class);
        //PublicationService publicationService = myObjectFactory.getByType(PublicationService.class);
        Story story1 = new Story("Hello PSG");
        Story story2 = new Story("Hello OM");

        //WHEN
        publicationService.share(story1);
        publicationService.share(story2);

        ///THEN
        List stories = storyRepository.findAll();
        Assert.assertEquals(2,stories.size());
        Assert.assertEquals(asList(story1, story2), stories);

    }


}