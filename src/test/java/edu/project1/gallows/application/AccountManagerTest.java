package edu.project1.gallows.application;
import edu.project1.gallows.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_METHOD)
public class AccountManagerTest {

    @Test
    public void testLogin_ValidCredentials_ShouldSetCurrentUser() {
        // Arrange
        User user = new User("testUser", "password");
        AccountManager.getUsers().add(user);
        // Act
        AccountManager.login("testUser", "password");
        // Assert
        assertThat(AccountManager.getCurrentUser()).isEqualTo(user);
    }

    @Test
    public void testLogout_ShouldReturnGoodbyeMessageAndClearCurrentUser() {
        // Arrange
        User user = new User("testUser", "password");
        AccountManager.getUsers().add(user);
        AccountManager.login("testUser", "password");
        // Act
        String result = AccountManager.logout();
        // Assert
        assertThat(result).isEqualTo("Goodbye, testUser! We'll be waiting for your come back.");
        assertThat(AccountManager.getCurrentUser()).isNull();
    }

    @Test
    public void testRegister_UserDoesNotExist_ShouldAddUser() {
        // Arrange
        User user = new User("newUser", "password");
        AccountManager.getUsers().clear();
        // Act
        AccountManager.register(user);
        // Assert
        assertThat(AccountManager.getUsers()).contains(user);
    }

    @Test
    public void testRegister_UserExists_ShouldNotAddUser() {
        // Arrange
        User user = new User("existingUser", "password");
        AccountManager.getUsers().add(user);
        int initialSize = AccountManager.getUsers().size();
        // Act
        AccountManager.register(user);
        // Assert
        assertThat(AccountManager.getUsers()).hasSize(initialSize);
    }

}
