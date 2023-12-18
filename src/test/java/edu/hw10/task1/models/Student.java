package edu.hw10.task1.models;

import edu.hw10.task1.annotations.Maximum;
import edu.hw10.task1.annotations.Minimum;
import edu.hw10.task1.annotations.NotNull;

public class Student {

    private final int course;
    private final String name;

    public Student(
        @Minimum(1) @Maximum(4) int course,
        @NotNull String name
    ) {
        this.course = course;
        this.name = name;
    }

    public static Student create(
        @Minimum(1) @Maximum(4) int course,
        @NotNull String name
    ) {
        return new Student(course, name);
    }

    public int getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }

}
