package com.polytech.polynet.repository;

import com.polytech.polynet.business.Comment;
import com.polytech.polynet.business.Story;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcStoryRepository implements StoryRepository {

    private DataSource dataSource;

    public JdbcStoryRepository(DataSource dataSource){
        this.dataSource = dataSource;
    };

    public List<Story> findAll() {

        List<Story> results= new ArrayList();

        try {
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM STORY";
            //EXECUTE QUERY
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            // FOR EACH ROW IN DATA BASE
            while (resultSet.next()) {
                //I GET THE CONTENT COLUMN
                String content = resultSet.getString( "CONTENT");
                Long id = resultSet.getLong( "ID");
                List<Comment> commentaires = comment_findAll(id);
                Story story = new Story(content, commentaires, id);
                //I ADD THE STORY TO THE RESULT
                results.add(story);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return results;
    }

    public List<Comment> comment_findAll(long id){
        List<Comment> results = new ArrayList();
        try{
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM COMMENT WHERE STORY_ID=" + id;
            //EXECUTE QUERY
            ResultSet resultSet = connection.createStatement().executeQuery(sql);

            // FROM EACH ROW IN DATA BASE
            while (resultSet.next()){
                // I GET THE CONTENT COLUMN
                String content = resultSet.getString("CONTENT");
                String id_story = resultSet.getString("STORY_ID");
                Comment comment = new Comment(content,id_story);
                // I ADD THE STORY TO THE RESULT
                results.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public void save(Story story){
        try{
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql =  "INSERT INTO STORY(CONTENT) VALUES('" + story.getContent() + "')";
            //EXECUTE QUERY
            connection.createStatement().execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void save_com(Comment comment){
        try{
            //GET CONNECTION
            Connection connection = dataSource.getConnection();
            String sql =  "INSERT INTO COMMENT(CONTENT,STORY_ID) VALUES('" + comment.getContent() + "','" + comment.getIdentifiant() + "')";
            //EXECUTE QUERY
            connection.createStatement().execute(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
