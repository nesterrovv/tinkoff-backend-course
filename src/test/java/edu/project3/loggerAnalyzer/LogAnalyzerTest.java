package edu.project3.loggerAnalyzer;

import edu.project3.loggerAnalyzer.analyzer.NginxAnalyzer;
import edu.project3.loggerAnalyzer.report.Report;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static edu.project3.loggerAnalyzer.typeManager.LogsTypeManager.getNginxLogsAnalyzer;
import static org.assertj.core.api.Assertions.assertThat;

public class LogAnalyzerTest {

    private static final String VALID_MARKDOWN_REPORT
        = "src/test/java/edu/project3/loggerAnalyzer/report/ValidMarkdownReport.md";
    private static final String VALID_ADOC_REPORT
        = "src/test/java/edu/project3/loggerAnalyzer/report/ValidAdocReport.adoc";

    @Test
    void testMarkdownReport() {
        // Arrange
        String[] args = {
            "--path", "logs/test*"
        };
        String expected;
        try {
            expected = Files.readString(Paths.get(VALID_MARKDOWN_REPORT));
        } catch (IOException ignored) {
            expected = "";
        }
        // Act
        NginxAnalyzer nginxLogAnalyzer = getNginxLogsAnalyzer(args);
        Report result = nginxLogAnalyzer.fullyAnalyze();
        // Assert
        assertThat(result.getReport()).isEqualTo(expected);
    }

    @Test
    void testAdocReport() {
        // Arrange
        String[] args = {
            "--path", "logs/test*",
            "--format", "adoc"
        };
        String expected;
        try {
            expected = Files.readString(Paths.get(VALID_ADOC_REPORT));
        } catch (IOException ignored) {
            expected = "";
        }
        // Act
        NginxAnalyzer nginxLogAnalyzer = getNginxLogsAnalyzer(args);
        Report result = nginxLogAnalyzer.fullyAnalyze();
        // Assert
        assertThat(result.getReport()).isEqualTo(expected);
    }

}
