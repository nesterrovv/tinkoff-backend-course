package edu.hw6.task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static edu.hw6.FilesUtils.createDirectory;
import static edu.hw6.FilesUtils.createFile;
import static edu.hw6.FilesUtils.deleteDirectory;
import static edu.hw6.FilesUtils.deleteFile;
import static org.assertj.core.api.Assertions.assertThat;

public class RegexContainsFilterTest {
    private static final String TEST_DIRECTORY = "src/test/java/edu/hw6/task3/test";
    private static final String TEST_FILE1 = "file1.txt";
    private static final String TEST_FILE2 = "file2.txt";
    private static final String REGEX_PATTERN = ".*file1.txt$";

    private Path testDirectoryPath;
    private Path testFile1Path;
    private Path testFile2Path;

    @BeforeEach
    void setUp() {
        testDirectoryPath = Path.of(TEST_DIRECTORY);
        testFile1Path = Paths.get(TEST_DIRECTORY, TEST_FILE1);
        testFile2Path = Paths.get(TEST_DIRECTORY, TEST_FILE2);

        createDirectory(testDirectoryPath);
        createFile(testFile1Path);
        createFile(testFile2Path);
    }

    @AfterEach
    void tearDown() {
        deleteFile(testFile1Path);
        deleteFile(testFile2Path);
        deleteDirectory(testDirectoryPath);
    }

    @Test
    void testRegexContainsFilter() throws IOException {
        // Arrange
        DirectoryStream.Filter<Path> filter
            = RegexContainsFilter.regexContains(REGEX_PATTERN);
        String expected = TEST_FILE1;

        // Act
        var result = new ArrayList<String>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(testDirectoryPath, filter)) {
            entries.forEach(filePath ->
                result.add(filePath.getFileName().toString())
            );
        }

        // Assert
        assertThat(result).containsExactly(expected);
    }
}
