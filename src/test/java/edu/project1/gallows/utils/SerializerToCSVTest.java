package edu.project1.gallows.utils;

import edu.project1.gallows.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class SerializerToCSVTest {

    @BeforeEach
    public void setUp() {}

    @Test
    public void testSerializeUsersToCSV_ValidUsers_ShouldWriteCSVFile() {
        // Arrange
        Set<User> users = new HashSet<>();
        users.add(new User("user1", "password1", 5, 2));
        users.add(new User("user2", "password2", 3, 4));
        // Act and Assert
        assertThatCode(() -> SerializerToCSV.serializeUsersToCSV(users))
            .doesNotThrowAnyException();
    }

    @Test
    public void testDeserializeUsersFromCSV_ValidCSVFile_ShouldReturnUsers() {
        // Arrange
        Set<User> users = new HashSet<>();
        users.add(new User("user1", "password1", 5, 2));
        users.add(new User("user2", "password2", 3, 4));
        SerializerToCSV.serializeUsersToCSV(users);
        // Act
        Set<User> deserializedUsers = SerializerToCSV.deserializeUsersFromCSV();
        // Assert
        assertThat(deserializedUsers).isNotNull();
        assertThat(deserializedUsers).hasSize(3);
        assertThat(deserializedUsers).contains(users.toArray(new User[0]));
    }

}

