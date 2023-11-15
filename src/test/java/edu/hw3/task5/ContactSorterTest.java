package edu.hw3.task5;

import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw3.task5.ContactSorter.parseContacts;
import static org.assertj.core.api.Assertions.assertThat;

class ContactSorterTest {

    @Test
    void testEmptyInDescendingOrder() {
        // Arrange
        String[] names = {};
        var order = Order.DESC;
        List<PhoneContact> expected = List.of();
        // Act
        List<PhoneContact> contacts = parseContacts(names, order);
        // Assert
        assertThat(contacts).isEqualTo(expected);
    }


    @Test
    void testEmptyInAscendingOrder() {
        // Arrange
        String[] names = {};
        var order = Order.ASC;
        List<PhoneContact> expected = List.of();
        // Act
        List<PhoneContact> contacts = parseContacts(names, order);
        // Assert
        assertThat(contacts).isEqualTo(expected);
    }

    @Test
    void testNullInDescendingOrder() {
        // Arrange
        String[] fullNames = null;
        var order = Order.DESC;
        List<PhoneContact> expected = List.of();
        // Act
        List<PhoneContact> contacts = parseContacts(fullNames, order);
        // Assert
        assertThat(contacts).isEqualTo(expected);
    }

    @Test
    void testNullInAscendingOrder() {
        // Arrange
        String[] fullNames = null;
        var order = Order.ASC;
        List<PhoneContact> expected = List.of();
        // Act
        List<PhoneContact> contacts = parseContacts(fullNames, order);
        // Assert
        assertThat(contacts).isEqualTo(expected);
    }

    @Test
    void testFullNamesInAscendingOrder() {
        // Arrange
        String[] names = {"Abc Abc", "Bcd Bcd", "Dce Dce"};
        var order = Order.ASC;
        List<PhoneContact> expected = List.of(
            new PhoneContact("Abc", "Abc"),
            new PhoneContact("Bcd", "Bcd"),
            new PhoneContact("Dce", "Dce")
        );
        // Act
        List<PhoneContact> contacts = parseContacts(names, order);
        // Assert
        assertThat(contacts).isEqualTo(expected);
    }

    @Test
    void testFullNamesInDescendingOrder() {
        // Arrange
        String[] names = {"Abc Abc", "Bcd Bcd", "Dce Dce"};
        var order = Order.DESC;
        List<PhoneContact> expected = List.of(
            new PhoneContact("Dce", "Dce"),
            new PhoneContact("Bcd", "Bcd"),
            new PhoneContact("Abc", "Abc")
        );
        // Act
        List<PhoneContact> contacts = parseContacts(names, order);
        // Assert
        assertThat(contacts).isEqualTo(expected);
    }

    @Test
    void testFirstNamesAndNullSurnameInDescendingOrder() {
        // Arrange
        String[] names = {"Abc", "Bcd", "Dce"};
        var order = Order.DESC;
        List<PhoneContact> expected = List.of(
            new PhoneContact("Dce", null),
            new PhoneContact("Bcd", null),
            new PhoneContact("Abc", null)
        );
        // Act
        List<PhoneContact> contacts = parseContacts(names, order);
        // Assert
        assertThat(contacts).isEqualTo(expected);
    }

    @Test
    void testFirstNamesAndNullSurnameInAscendingOrder() {
        // Arrange
        String[] names = {"Abc", "Bcd", "Dce"};
        var order = Order.ASC;
        List<PhoneContact> expected = List.of(
            new PhoneContact("Abc", null),
            new PhoneContact("Bcd", null),
            new PhoneContact("Dce", null)
        );
        // Act
        List<PhoneContact> contacts = parseContacts(names, order);
        // Assert
        assertThat(contacts).isEqualTo(expected);
    }

}
