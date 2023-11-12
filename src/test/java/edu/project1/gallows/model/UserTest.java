package edu.project1.gallows.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        // Arrange
        user = new User("testUser", "password");
    }

    @Test
    public void testDefaultConstructor() {
        // Arrange
        User defaultUser = new User();
        // Assert
        assertThat(defaultUser).isNotNull();
    }

    @Test
    public void testParameterizedConstructor() {
        // Assert
        assertThat(user.getLogin()).isEqualTo("testUser");
        assertThat(user.getPassword()).isEqualTo("password");
        assertThat(user.getWins()).isZero();
        assertThat(user.getLoses()).isZero();
    }

    @Test
    public void testIncreaseWins() {
        // Act
        user.increaseWins();
        // Assert
        assertThat(user.getWins()).isEqualTo(1);
    }

    @Test
    public void testIncreaseLoses() {
        // Act
        user.increaseLoses();
        // Assert
        assertThat(user.getLoses()).isEqualTo(1);
    }

    @Test
    public void testEqualsAndHashCode() {
        // Arrange
        User sameUser = new User("testUser", "password");
        User differentUser = new User("otherUser", "password");
        // Assert
        assertThat(user).isEqualTo(sameUser);
        assertThat(user.hashCode()).isEqualTo(sameUser.hashCode());
        assertThat(user).isNotEqualTo(differentUser);
        assertThat(user.hashCode()).isNotEqualTo(differentUser.hashCode());
    }

    @Test
    public void testToString() {
        // Act
        String userString = user.toString();
        // Assert
        assertThat(userString).contains("login='testUser'");
        assertThat(userString).contains("password='password'");
        assertThat(userString).contains("wins=0");
        assertThat(userString).contains("loses=0");
    }

    @Test
    public void testSetters() {
        // Act
        user.setLogin("newUser");
        user.setPassword("newPassword");
        user.setWins(5);
        user.setLoses(3);
        // Assert
        assertThat(user.getLogin()).isEqualTo("newUser");
        assertThat(user.getPassword()).isEqualTo("newPassword");
        assertThat(user.getWins()).isEqualTo(5);
        assertThat(user.getLoses()).isEqualTo(3);
    }

}

