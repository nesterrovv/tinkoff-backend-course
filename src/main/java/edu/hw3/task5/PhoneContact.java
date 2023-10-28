package edu.hw3.task5;

import org.jetbrains.annotations.NotNull;

public record PhoneContact(String firstName, String secondName) implements Comparable<PhoneContact> {

    @Override
    public int compareTo(@NotNull PhoneContact another) {
        if (this.secondName == null || another.secondName == null) {
            return this.firstName.compareTo(another.firstName);
        }
        int secondNameComparison = this.secondName.compareTo(another.secondName);
        if (secondNameComparison == 0) {
            return this.firstName.compareTo(another.firstName);
        }
        return secondNameComparison;
    }

}
