package gall_bot.repository;

import gall_bot.DBWorker;
import gall_bot.dto.WordDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WordRepository {
    private DBWorker dbWorker;

    public boolean save(WordDto wordDto) {
        try {
            dbWorker = new DBWorker();
            Connection connection=dbWorker.getConnection();
            return connection.createStatement().execute(
                    String.format("insert into words(word_id, word, word_theme) values ('%d', '%s', '%d') ", wordDto.getWordId(),
                            wordDto.getWord(), wordDto.getWordTheme()));

        } catch (SQLException e) {
            System.err.println("Failed to save word with Id = " + wordDto.getWordId() + e);
        }
        return false;
    }

    public String getWordById(Integer id){
        try{
            dbWorker = new DBWorker();
            Connection connection=dbWorker.getConnection();
            ResultSet resultSet= connection.createStatement().executeQuery("SELECT word\n" +
                    "FROM words WHERE word_id = "+id);
            resultSet.next();
            return resultSet.getString("word");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
