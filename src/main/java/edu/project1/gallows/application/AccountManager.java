package edu.project1.gallows.application;

import edu.project1.gallows.model.User;
import edu.project1.gallows.utils.SerializerToCSV;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class AccountManager {

    private static AccountManager instance;
    private static User currentUser;
    private static Set<User> users = new HashSet<>();

   static {
       users = SerializerToCSV.deserializeUsersFromCSV();
   }

   private AccountManager() {}

    public static void login(String login, String hexPassword) {
        User current = getUserViaCredentials(login, hexPassword);
        if (current == null) {
            register(new User(login, hexPassword));
            login(login, hexPassword);
        } else {
            currentUser = current;
        }
    }

    public static String logout() {
        String login = currentUser.getLogin();
        currentUser = null;
        return "Goodbye, " + login + "! We'll be waiting for your come back.";
    }

    public static void register(User user) {
        int initialSize = users.size();
        users.add(user);
        if (users.size() == initialSize) {
            log.warn("Account is already exists.");
        }
    }

    public static User getUserViaCredentials(String login, String hexPassword) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(hexPassword)) {
                return user;
            }
        }
        return null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Set<User> getUsers() {
        return users;
    }

}
