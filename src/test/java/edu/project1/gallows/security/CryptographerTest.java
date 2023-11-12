package edu.project1.gallows.security;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptographerTest {

    @Test
    public void testEncrypt_ValidInput_ShouldReturnEncryptedString() {
        // Arrange
        String input = "testString";
        // Act
        String encryptedString = Cryptographer.encrypt(input);
        // Assert
        assertThat(encryptedString).isNotEmpty();
        assertThat(encryptedString).isNotEqualTo(input);
    }

    @Test
    public void testEncrypt_EmptyInput_ShouldReturnEmptyString() {
        // Arrange
        String input = "";
        // Act
        String encryptedString = Cryptographer.encrypt(input);
        // Assert
        assertThat(encryptedString).isEmpty();
    }

    @Test
    public void testEncrypt_NullInput_ShouldReturnNull() {
        // Arrange
        String input = null;
        // Act
        String encryptedString = Cryptographer.encrypt(input);
        // Assert
        assertThat(encryptedString).isNull();
    }

}
