package com.polytech.polynet.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polynet.business.FeedService;
import com.polytech.polynet.business.FeedServiceImpl;
import com.polytech.polynet.business.PublicationService;
import com.polytech.polynet.business.PublicationServiceImpl;
//import com.polytech.polynet.repository.JdbcStoryRepository;
import com.polytech.polynet.repository.JpaStoryRepository;
import com.polytech.polynet.repository.StoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    StoryRepository storyRepository() {
        return new JpaStoryRepository();
    }

    //@Bean
    //StoryRepository storyRepository() {
    //    return new JdbcStoryRepository(datasource());
    //}

    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/polynet");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDatabaseName("polyNet");
        return dataSource;
    }

    @Bean
    FeedService feedService() { return new FeedServiceImpl((storyRepository())); }

    @Bean
    PublicationService publicationService(){
        return new PublicationServiceImpl(storyRepository());
    }
}