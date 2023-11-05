package edu.hw4.checker;

import edu.hw4.animal.Animal;
import edu.hw4.errors.AgeError;
import edu.hw4.errors.HeightError;
import edu.hw4.errors.ValidationError;
import edu.hw4.errors.WeightError;
import java.util.ArrayList;
import java.util.List;

public final class AnimalChecker {
    private AnimalChecker() {}

    public static List<ValidationError> getValidationErrors(Animal animal) {
        List<ValidationError> errors = new ArrayList<>();

        if (animal.age() <= 0) {
            errors.add(new AgeError("age must be greater than zero"));
        }

        if (animal.height() <= 0) {
            errors.add(new HeightError("height must be greater than zero"));
        }

        if (animal.weight() <= 0) {
            errors.add(new WeightError("weight must be greater than zero"));
        }

        return errors;
    }
}
