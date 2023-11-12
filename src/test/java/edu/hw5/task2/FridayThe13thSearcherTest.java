package edu.hw5.task2;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class FridayThe13thSearcherTest {

    @Test
    void findFridays13_ValidYear_ReturnsListOfFridays13() {
        // Arrange
        int year = 1925;
        // Act
        List<String> fridays13 = FridayThe13thSearcher.findFridays13(year);
        // Assert
        assertThat(fridays13).isNotEmpty();
        assertThat(fridays13).contains("1925-02-13", "1925-03-13", "1925-11-13");
    }

    @Test
    void findFridays13_InvalidYear_ReturnsEmptyList() {
        // Arrange
        int year = -1925;
        // Act
        List<String> fridays13 = FridayThe13thSearcher.findFridays13(year);
        // Assert
        assertThat(fridays13).isEmpty();
    }

}
