package controller;

import dao.UserDao;
import model.User;

import java.sql.SQLException;

public class Menu {

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.wyswietlMenu();
    }

    public void wyswietlMenu() throws SQLException {
        UserDao userDao = new UserDao();

        userDao.save(new User("Marcino","Banas","mban@wp.pl"));
    }
}
