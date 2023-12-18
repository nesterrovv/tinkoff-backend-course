package edu.hw10.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import edu.hw10.task2.fibonacci.FibonacciCalculator;
import edu.hw10.task2.fibonacci.RecursiveFibonacciCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static edu.hw10.task2.FilesUtils.deleteFile;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

public class CacheProxyTest {

    private Path cacheDirectory = Path.of("src/test/java/edu/hw10/task2/");

    private static final long[] FIBONACCI_NUMBERS = {
        0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L
    };

    @AfterEach
    void deleteCacheFile() {
        deleteFile(cacheDirectory.resolve("cache.txt"));
    }

    @Test
    void functionIsInvokedOnce() {
        // Arrange
        FibonacciCalculator mock = mock(RecursiveFibonacciCalculator.class);
        FibonacciCalculator proxy = CacheProxy.create(mock, mock.getClass(), cacheDirectory);
        for (int i = 0; i < FIBONACCI_NUMBERS.length; ++i) {
            // Extra-arrange
            when(mock.fibonacci(i)).thenReturn(FIBONACCI_NUMBERS[i]);
            // Act && Assert
            assertThat(proxy.fibonacci(i)).isEqualTo(FIBONACCI_NUMBERS[i]);
            assertThat(proxy.fibonacci(i)).isEqualTo(FIBONACCI_NUMBERS[i]);
            assertThat(proxy.fibonacci(i)).isEqualTo(FIBONACCI_NUMBERS[i]);
            // Assert
            Mockito.verify(mock, Mockito.times(1)).fibonacci(i);
        }
    }

    @Test
    void getValuesFromCache() {
        // Arrange
        FibonacciCalculator mock = mock(RecursiveFibonacciCalculator.class);
        FibonacciCalculator proxy = CacheProxy.create(mock, mock.getClass(), cacheDirectory);
        for (int i = 0; i < FIBONACCI_NUMBERS.length; ++i) {
            // Extra-arrange
            when(mock.fibonacci(i)).thenReturn(FIBONACCI_NUMBERS[i]);
            // Act & Assert
            assertThat(proxy.fibonacci(i)).isEqualTo(FIBONACCI_NUMBERS[i]);
            assertThat(proxy.fibonacci(i)).isEqualTo(FIBONACCI_NUMBERS[i]);
            assertThat(proxy.fibonacci(i)).isEqualTo(FIBONACCI_NUMBERS[i]);
            // Extra-assert
            Mockito.verify(mock, Mockito.times(1)).fibonacci(i);
        }
        // Arrange
        reset(mock);
        FibonacciCalculator newProxy = CacheProxy.create(mock, mock.getClass(), cacheDirectory);
        for (int i = 0; i < FIBONACCI_NUMBERS.length; ++i) {
            // Act & Assert
            assertThat(newProxy.fibonacci(i)).isEqualTo(FIBONACCI_NUMBERS[i]);
            // Assert
            Mockito.verify(mock, Mockito.times(0)).fibonacci(i);
        }
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

