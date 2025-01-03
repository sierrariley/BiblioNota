package com.example.biblionota.tables;

import com.example.biblionota.dao.GenreDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Author;
import com.example.biblionota.pojo.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * GenreTable class implements GenreDAO
 */
public class GenreTable implements GenreDAO {
    private static GenreTable instance;
    Database db;
    ArrayList<Genre> genres;

    private GenreTable() { db = Database.getInstance(); }
    @Override
    /**
     * Gives all genres in table
     */
    public ArrayList<Genre> getAllGenres() {
        String query = "SELECT * FROM " + DBConst.TABLE_GENRE;
        genres = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                genres.add(new Genre(
                        data.getInt(DBConst.GENRE_COLUMN_ID),
                        data.getString(DBConst.GENRE_COLUMN_NAME)
                ));
            }
            return genres;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Get genre by its id
     * @param id
     * @return
     */
    @Override
    public Genre getGenre(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_GENRE +
                " WHERE " + DBConst.GENRE_COLUMN_ID + " = " + id;
        genres = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                return new Genre(
                        data.getInt(DBConst.GENRE_COLUMN_ID),
                        data.getString(DBConst.GENRE_COLUMN_NAME)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Created a new genre
     * @param genre
     */
    @Override
    public void createGenre(Genre genre) {
        String query = "INSERT INTO " + DBConst.TABLE_GENRE +
                "(" + DBConst.GENRE_COLUMN_NAME + ") VALUES ('" +
                genre.getName() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Updates a genre from table
     * @param genre
     */
    @Override
    public void updateGenre(Genre genre) {
        String query = "UPDATE " + DBConst.TABLE_GENRE + " SET " +
                DBConst.GENRE_COLUMN_NAME + "= " + genre.getName() +
                " WHERE " + DBConst.GENRE_COLUMN_ID + " = " + genre.getId();
        try {
            Statement updateGenre = db.getConnection().createStatement();
            updateGenre.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static GenreTable getInstance() {
        if(instance == null){
            instance = new GenreTable();
        }
        return instance;
    }
}
