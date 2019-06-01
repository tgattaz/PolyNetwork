package com.polytech.polynet.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polynet.business.*;
import com.polytech.polynet.repository.JpaUserRepository;
import com.polytech.polynet.repository.JpaToDoRepository;
import com.polytech.polynet.repository.UserRepository;
import com.polytech.polynet.repository.ToDoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    ToDoRepository storyRepository() {
        return new JpaToDoRepository();
    }

    @Bean
    UserRepository loginRepository() {
        return new JpaUserRepository();
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