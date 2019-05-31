package com.polytech.polynet.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polynet.business.*;
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

    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://mysql-tgattaz.alwaysdata.net:3306/tgattaz_polynet");
        dataSource.setUser("tgattaz_parano");
        dataSource.setPassword("parano13014");
        dataSource.setDatabaseName("tgattaz_polynet");
        return dataSource;
    }

    @Bean
    ToDoService toDoService() { return new ToDoServiceImpl((storyRepository())); }

    @Bean
    PublicationService publicationService(){
        return new PublicationServiceImpl(storyRepository());
    }

    @Bean
    LoginService loginService(){
        return new LoginServiceImpl(loginRepository());
    }
}