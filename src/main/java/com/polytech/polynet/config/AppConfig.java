package com.polytech.polynet.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polynet.business.*;
//import com.polytech.polynet.repository.JdbcStoryRepository;
import com.polytech.polynet.repository.JpaLoginRepository;
import com.polytech.polynet.repository.JpaStoryRepository;
import com.polytech.polynet.repository.LoginRepository;
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

    @Bean
    LoginRepository loginRepository() {
        return new JpaLoginRepository();
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

    @Bean
    LoginService loginService(){
        return new LoginServiceImpl(loginRepository());
    }
}