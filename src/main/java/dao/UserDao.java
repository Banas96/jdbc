package dao;

import config.Database;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private Database database = new Database();

    // save
    public User save(User user) throws SQLException {
        //insert
        // 1. pobierz połączenie
        Connection connection = database.getConnection();

        // 2. napisz zapytanie
        /*
        String sql = "INSERT INTO user (first_name, last_name, email) " +
                     "VALUES (" + user.getFirstName() + ", " +
                                  user.getLastName() + ", " +
                                  user.getEmail()+  ")";
            firstName = ";DROP DATABASE;"     potecjalnie SQL Injection
        */
        String sql = "INSERT INTO user (first_name, last_name, email) " +
                     "VALUES (?,?,?)";

        // 3. utworz obiekt PreparedStatment
        PreparedStatement statement = connection.prepareStatement(sql);

        // 4. uzupełnij znaki zapytania
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail());

        // 5. wykonaj zapytanie w bazie
        statement.executeUpdate();

        return user;
    }

    // update
    public void update(User user){

    }
    // delete
    public void delete(int id){

    }
    // findById
    public User findById(int id){
        return null;
    }

    // findAll
    public List<User> findAll(){
        return null;
    }
}
