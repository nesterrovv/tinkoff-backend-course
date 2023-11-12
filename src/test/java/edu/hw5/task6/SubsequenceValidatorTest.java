package edu.hw5.task6;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SubsequenceValidatorTest {

    @Test
    void isSubsequence_WhenSubsequence_ReturnsTrue() {
        // Arrange
        String s = "abc";
        String t = "achfdbaabgabcaabg";
        // Act
        boolean isSubsequence = SubsequenceValidator.isSubsequence(s, t);
        // Assert
        assertThat(isSubsequence).isTrue();
    }

    @Test
    void isSubsequence_WhenNotSubsequence_ReturnsFalse() {
        // Arrange
        String s = "xyz";
        String t = "achfdbaabgabcaabg";
        // Act
        boolean isSubsequence = SubsequenceValidator.isSubsequence(s, t);
        // Assert
        assertThat(isSubsequence).isFalse();
    }

    @Test
    void isSubsequence_WhenEmptyString_ReturnsFalse() {
        // Arrange
        String s = "";
        String t = "achfdbaabgabcaabg";
        // Act
        boolean isSubsequence = SubsequenceValidator.isSubsequence(s, t);
        // Assert
        assertThat(isSubsequence).isFalse();
    }

    @Test
    void isSubsequence_WhenBothEmptyStrings_ReturnsTrue() {
        // Arrange
        String s = "";
        String t = "";
        // Act
        boolean isSubsequence = SubsequenceValidator.isSubsequence(s, t);
        // Assert
        assertThat(isSubsequence).isTrue();
    }

    @Test
    void isSubsequence_WhenSIsNull_ReturnsFalse() {
        // Arrange
        String s = null;
        String t = "achfdbaabgabcaabg";
        // Act
        boolean isSubsequence = SubsequenceValidator.isSubsequence(s, t);
        // Assert
        assertThat(isSubsequence).isFalse();
    }

    @Test
    void isSubsequence_WhenTIsNull_ReturnsFalse() {
        // Arrange
        String s = "abc";
        String t = null;
        // Act
        boolean isSubsequence = SubsequenceValidator.isSubsequence(s, t);
        // Assert
        assertThat(isSubsequence).isFalse();
    }

    @Test
    void isSubsequence_WhenBothAreNull_ReturnsFalse() {
        // Arrange
        String s = null;
        String t = null;
        // Act
        boolean isSubsequence = SubsequenceValidator.isSubsequence(s, t);
        // Assert
        assertThat(isSubsequence).isFalse();
    }

}

