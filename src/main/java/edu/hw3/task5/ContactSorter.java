package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class ContactSorter {
    private ContactSorter() {}

    private final static String SPLIT_REGEX = " ";


    public static List<PhoneContact> parseContacts(String[] fullNames, Order order) {
        if (checkIsArrayEmpty(fullNames)) {
            return new ArrayList<>();
        }
        List<PhoneContact> contacts = createContacts(fullNames);
        sortContacts(contacts, order);
        return contacts;
    }

    private static boolean checkIsArrayEmpty(String[] array) {
        return array == null || array.length == 0;
    }

    private static List<PhoneContact> createContacts(String[] fullNames) {
        List<PhoneContact> contacts = new ArrayList<>(fullNames.length);
        for (String fullName : fullNames) {
            String[] data = fullName.split(SPLIT_REGEX);
            String firstName = data[0];
            String secondName = data.length == 2 ? data[1] : null;
            contacts.add(new PhoneContact(firstName, secondName));
        }
        return contacts;
    }

    private static void sortContacts(List<PhoneContact> contacts, Order order) {
        Comparator<PhoneContact> comparator = switch (order) {
            case ASC  -> Comparator.naturalOrder();
            case DESC -> Comparator.reverseOrder();
        };
        contacts.sort(comparator);
    }

}
