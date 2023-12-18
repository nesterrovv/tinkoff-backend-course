package edu.hw10.task1.models;

import edu.hw10.task1.annotations.Maximum;
import edu.hw10.task1.annotations.Minimum;
import edu.hw10.task1.annotations.NotNull;

public record StudentRecord(
    @Minimum(1) @Maximum(4) int course,
    @NotNull String name
) {

}
