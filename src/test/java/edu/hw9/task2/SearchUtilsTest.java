package edu.hw9.task2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import static edu.hw9.task2.FilesUtils.createDirectory;
import static edu.hw9.task2.FilesUtils.createFile;
import static edu.hw9.task2.FilesUtils.deleteDirectory;
import static edu.hw9.task2.FilesUtils.deleteFile;
import static edu.hw9.task2.FilesUtils.writeStringToEndOfFile;
import static edu.hw9.task2.SearchUtils.findDirectories;
import static edu.hw9.task2.SearchUtils.findFiles;
import static org.assertj.core.api.Assertions.assertThat;

final class SearchUtilsTest {
    private static final Path root = Paths.get("src/test/java/edu/hw9/task2/");

    @BeforeAll
    static void createContent() {
        createDirectory(root.resolve("test/"));
        createDirectory(root.resolve("test/test11/"));
        createDirectory(root.resolve("test/test12/"));
        createDirectory(root.resolve("test/test11/test21/"));
        createDirectory(root.resolve("test/test11/test22/"));
        createFile(root.resolve("test/test11/test21.txt"));
        writeStringToEndOfFile(root.resolve("test/test11/test21.txt"), "6BYTES");
        createFile(root.resolve("test/test11/test21/test31.txt"));
        createFile(root.resolve("test/test11/test22/test31.md"));
        writeStringToEndOfFile(root.resolve("test/test11/test22/test31.md"), "6BYTES");
        createFile(root.resolve("test/test12/test21.txt"));
        createFile(root.resolve("test/test12/test22.txt"));
        writeStringToEndOfFile(root.resolve("test/test12/test22.txt"), "7 BYTES");
    }

    @AfterAll
    static void deleteContent() {
        deleteFile(root.resolve("test/test11/test21.txt"));
        deleteFile(root.resolve("test/test11/test21/test31.txt"));
        deleteFile(root.resolve("test/test11/test22/test31.md"));
        deleteFile(root.resolve("test/test12/test21.txt"));
        deleteFile(root.resolve("test/test12/test22.txt"));
        deleteDirectory(root.resolve("test/test11/test21/"));
        deleteDirectory(root.resolve("test/test11/test22/"));
        deleteDirectory(root.resolve("test/test11/"));
        deleteDirectory(root.resolve("test/test12/"));
        deleteDirectory(root.resolve("test/"));
    }

    @Test
    void testDirectorySearch() {
        // Act
        List<Path> result = findDirectories(root.resolve("test/"), 2);
        // Assert
        assertThat(result).hasSize(2);
    }

    @Test
    void testFileSearch() {
        // Act
        List<Path> result = findFiles(root.resolve("test/"), 6, 6, ".txt");
        // Assert
        assertThat(result).hasSize(1);
    }
}

// TODO: реализовывал этот класс в HW #6, но пока не смердижл его, пришлось делать такой костыль
// TODO: Позже смерджу и поменяю импорты на обращение к HW #6, а этот класс удалю, пока нарушаю DRY :(
final class FilesUtils {
    private FilesUtils() {
    }

    public static boolean fileExists(Path filePath) {
        return Files.exists(filePath);
    }

    public static boolean directoryExists(Path directoryPath) {
        return Files.exists(directoryPath);
    }

    public static void createFile(Path filePath) {
        if (fileExists(filePath)) {
            return;
        }

        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createDirectory(Path directoryPath) {
        if (directoryExists(directoryPath)) {
            return;
        }

        try {
            Files.createDirectory(directoryPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFile(Path filePath) {
        if (!fileExists(filePath)) {
            return;
        }

        try {
            Files.delete(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteDirectory(Path directoryPath) {
        if (!directoryExists(directoryPath)) {
            return;
        }

        try {
            Files.delete(directoryPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void clearFile(Path filePath) {
        if (!fileExists(filePath)) {
            return;
        }

        deleteFile(filePath);
        createFile(filePath);
    }

    public static String getFirstLineFromFile(Path filePath) {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeStringToEndOfFile(Path filePath, String string) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            writer.write(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void cloneFile(Path filePath) {
        if (!fileExists(filePath)) {
            return;
        }

        final String fileNameSplitterRegexPattern = "\\.";
        final String suffixOfCopy = " — копия";

        Path directory = filePath.getParent();

        String[] fileName = filePath.getFileName().toString().split(fileNameSplitterRegexPattern);
        String baseName = fileName[0];
        String extension = fileName[1];

        int copyNumber = 1;
        String copyFileName = baseName + suffixOfCopy + "." + extension;
        Path copyFilePath = directory.resolve(copyFileName);

        while (Files.exists(copyFilePath)) {
            copyNumber++;
            copyFileName = baseName + suffixOfCopy + " (" + copyNumber + ")." + extension;
            copyFilePath = directory.resolve(copyFileName);
        }

        try {
            Files.copy(filePath, copyFilePath);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

}
