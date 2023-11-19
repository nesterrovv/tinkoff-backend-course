package edu.project3.loggerAnalyzer.analyzer.config;

import edu.project3.loggerAnalyzer.provider.source.PathSourceMatcher;
import edu.project3.loggerAnalyzer.provider.source.Source;
import edu.project3.loggerAnalyzer.provider.source.UrlSource;
import edu.project3.loggerAnalyzer.report.LogsReporter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.OffsetDateTime;
import picocli.CommandLine;

@CommandLine.Command(
    name = "Nginx log files analysis",
    description = "Return nginx log files analysis report."
) public class NginxConfig {

    public NginxConfig() {}

    @CommandLine.Option(
        names = {"--path"},
        description = "Path to one or more NGINX log files in form of a local template or URL.",
        required = true
    ) private Source source;
    @CommandLine.Option(
        names = {"--from"},
        description = "Optional time parameter from in ISO-8601 format, such as '2000-02-22T00:00:00+00:00'."
    ) private OffsetDateTime from;
    @CommandLine.Option(
        names = {"--to"},
        description = "Optional time parameter to in ISO-8601 format, , such as '2000-02-22T00:00:00+00:00'."
    ) private OffsetDateTime to;
    @CommandLine.Option(
        names = {"--format"},
        description = "Optional argument of output format of result."
    ) private LogsReporter.ReportFormat format;

    public void setSource(Source source) {
        this.source = source;
    }

    public void setFrom(OffsetDateTime from) {
        this.from = from;
    }

    public void setTo(OffsetDateTime to) {
        this.to = to;
    }

    public void setFormat(LogsReporter.ReportFormat format) {
        this.format = format;
    }

    public Source getSource() {
        return source;
    }

    public OffsetDateTime getFrom() {
        return from;
    }

    public OffsetDateTime getTo() {
        return to;
    }

    public LogsReporter.ReportFormat getFormat() {
        return format;
    }

    public static Source convert(String pattern) {
        try {
            return new UrlSource(pattern);
        } catch (URISyntaxException | IllegalArgumentException | MalformedURLException ignored) {
            return new PathSourceMatcher(pattern);
        }
    }

}
