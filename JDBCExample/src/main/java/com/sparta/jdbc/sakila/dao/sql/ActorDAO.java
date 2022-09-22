package com.sparta.jdbc.sakila.dao.sql;

import com.sparta.jdbc.sakila.dao.interfaces.DAO;
import com.sparta.jdbc.sakila.entities.Actor;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// Singleton
public class ActorDAO implements DAO<Actor> {
    private static Connection conn = null;
    private static ActorDAO theInstance = null;
    private static PreparedStatement findByIdPS = null;

    public static ActorDAO getInstance() {
        if (theInstance == null)
            theInstance = new ActorDAO();
        if (conn == null) {
            Properties props = new Properties();
            try {
                props.load(new FileReader("dbconnect.properties"));
                conn = DriverManager.getConnection(
                        props.getProperty("mysql.url"),
                        props.getProperty("mysql.username"),
                        props.getProperty("mysql.password"));
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (findByIdPS == null) {
            try {
                findByIdPS = conn.prepareStatement(
                        "SELECT * FROM actor WHERE actor_id = ?");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return theInstance;
    }

    private ActorDAO() {
    }

    @Override
    public int insert(Actor newRow) {
        PreparedStatement insertStatement = null;
        int newId = 0;
        try {
            insertStatement = conn.prepareStatement(
                    "INSERT INTO actor (first_name, last_name)" +
                            "VALUES (?, ?)");
            insertStatement.setString(1, newRow.getFirstName());
            insertStatement.setString(2, newRow.getLastName());
            // select * from actor where actor_id = max(actor_id)
            // or use ident_current("actor")?
            insertStatement.executeUpdate();
            Statement getIdStatement = conn.createStatement();
            // probably a better way of doing this
            ResultSet rs = getIdStatement.executeQuery(
                    "SELECT * FROM actor " +
                    "WHERE actor_id=(SELECT max(actor_id) FROM actor)");
            rs.next();
            newId = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newId;
    }

    @Override
    public Actor findById(int id) {
        Actor result;
        try {
            findByIdPS.setInt(1, id);
            ResultSet rs = findByIdPS.executeQuery();
            rs.next();
            result = new Actor(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Actor> findAll() {
        PreparedStatement findAllPS = null;
        ResultSet rs = null;
        List<Actor> result = new ArrayList<>();
        try {
            findAllPS = conn.prepareStatement(
                    "SELECT * FROM actor");
            rs = findAllPS.executeQuery();
            while (rs.next()) {
                result.add(new Actor(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void update(Actor updatedRow) {

    }

    @Override
    public void deleteById(int id) {

    }
}
