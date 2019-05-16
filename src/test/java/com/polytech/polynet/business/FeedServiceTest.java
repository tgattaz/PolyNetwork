package com.polytech.polynet.business;

import com.polytech.polynet.repository.InMemoryStoryRepository;
import com.polytech.polynet.repository.StoryRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class FeedServiceTest {

    @Test
    public void  should_fetch_user_feed() {

        //GIVEN Stories are already stored in database
        StoryRepository storyRepository = new InMemoryStoryRepository();
        FeedService feedService = new FeedServiceImpl(storyRepository);
        Story story1 = new Story("Hello PSG");
        Story story2 = new Story("Hello OM");
        storyRepository.save(story1);
        storyRepository.save(story2);

        //WHEN
        List stories = feedService.fetchAll();

        ///THEN
        Assert.assertEquals(2,stories.size());
        Assert.assertEquals(asList(story1, story2), stories);

    }

}