package edu.hw6.task2;

import java.nio.file.Path;
import java.nio.file.Paths;
import static edu.hw6.FilesUtils.cloneFile;
import static edu.hw6.FilesUtils.createFile;

@SuppressWarnings("UncommentedMain")
public final class Task2 {

    private Task2() {}

    private final static String TOP_SECRET_DIRECTORY = "src/main/java/edu/hw6/task2";
    private final static String TOP_SECRET_FILE = "Tinkoff Bank Biggest Secret.txt";

    public static void main(String[] args) {
        Path biggestSecret = Paths.get(TOP_SECRET_DIRECTORY, TOP_SECRET_FILE);
        createFile(biggestSecret);
        cloneFile(biggestSecret);
        cloneFile(biggestSecret);
        cloneFile(biggestSecret);
    }

}
