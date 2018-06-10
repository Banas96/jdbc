package controller;

import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.wyswietlMenu();
    }

    public void wyswietlMenu() throws SQLException {
        UserDao userDao = new UserDao();
        Scanner skaner = new Scanner(System.in); // tworzy nowy skaner
        List<User> userList;

        System.out.println("Choose operation");
        System.out.println("1 Add user ");
        System.out.println("2 Update user");
        System.out.println("3 Delete user");
        System.out.println("4 Show users");
        System.out.println("q Exit");

        String wybor = skaner.nextLine();
        switch (wybor) {
            case "1":
                // wczyta informacje o produkcie
                System.out.println("Name");
                String name = skaner.next();
                System.out.println("Last name");
                String lastName = skaner.next();
                System.out.println(" email");
                String email = skaner.next();
                User newUser = new User(name, lastName, email);
                userDao.save(newUser);
                System.out.println("Added new user");
                break; // kończy case'a
            case "2":
                userList = userDao.findAll();

                for(int i =0; i< userList.size();i++){
                    System.out.println(userList.get(i));
                }
                System.out.println("Choose id to update");
                int id = skaner.nextInt();
                skaner.nextLine();

                System.out.println("Name");
                name = skaner.next();
                System.out.println("Last name");
                lastName = skaner.next();
                System.out.println(" email");
                email = skaner.next();
                User updatedUser = new User(id, name, lastName, email);
                userDao.update(updatedUser);
                System.out.println("Updated the user ");
                break;
            case "3":
                userList = userDao.findAll();
                for(int i =0; i< userList.size();i++){
                    System.out.println(userList.get(i));
                }
                System.out.println("Choose id to delete");
                id = skaner.nextInt(); // wczyta id bazy, który chce usunąć
                skaner.nextLine();
                userDao.delete(id); // wywoła metode klasy userDao
                System.out.println("Deleted the user ");
                break; // kończy case'a
            case "4":
                userList = userDao.findAll();

                for(int i =0; i< userList.size();i++){
                    System.out.println(userList.get(i));
                }
                break; // kończy case'a
            case "q":
                System.out.println("Exit");
            default: // jeśli wpiszesz inną opcje niż podane to
                System.out.println("Operation not found");
                break; // kończy cała funkcje
        }
    }

}
