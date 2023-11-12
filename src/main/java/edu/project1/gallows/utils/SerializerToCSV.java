package edu.project1.gallows.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import edu.project1.gallows.application.AccountManager;
import edu.project1.gallows.model.User;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class SerializerToCSV {

    private static final String PATH_TO_USERS_FILE = "src/main/resources/project1/users.csv";

    private SerializerToCSV() {}

    public static void serializeUsersToCSV(Set<User> users) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(PATH_TO_USERS_FILE))) {
            String[] header = {"login", "password", "wins", "loses"};
            writer.writeNext(header);
            for (User user : users) {
                String[] userData = {user.getLogin(), user.getPassword(), String.valueOf(user.getWins()),
                    String.valueOf(user.getLoses())};
                writer.writeNext(userData);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @SuppressWarnings("MagicNumber")
    public static Set<User> deserializeUsersFromCSV() {
        Set<User> users = AccountManager.getUsers();
        try (CSVReader reader = new CSVReader(new FileReader(PATH_TO_USERS_FILE))) {
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length == 4) {
                    String login = nextLine[0];
                    String password = nextLine[1];
                    int wins = Integer.parseInt(nextLine[2]);
                    int loses = Integer.parseInt(nextLine[3]);
                    users.add(new User(login, password, wins, loses));
                }
            }
        } catch (IOException | CsvValidationException e) {
            log.error(e.getMessage());
        }
        if (users == null) {
            return new HashSet<>();
        }
        return users;
    }

}
