package edu.project1.gallows.application;

import edu.project1.gallows.model.User;
import edu.project1.gallows.util.SerializerToCSV;
import lombok.extern.slf4j.Slf4j;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
public class AccountManager {

    private static AccountManager instance;
    private static User currentUser;
    private static Set<User> users = new HashSet<>();

    private AccountManager() {
        instance = new AccountManager();
        users = SerializerToCSV.deserializeUsersFromCSV();
    }

    public AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public static void login(User user) {
        boolean isCorrectAccount = users.contains(user);
        if (isCorrectAccount) {
            currentUser = user;
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

    public static boolean checkIfUserExists(User user) {
        return users.contains(user);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Set<User> getUsers() {
        return users;
    }

}
