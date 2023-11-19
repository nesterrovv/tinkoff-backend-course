package edu.project3.loggerAnalyzer.analyzer;

import edu.project3.loggerAnalyzer.analyzer.assay.HttpStatusAssay;
import edu.project3.loggerAnalyzer.analyzer.assay.MostCommonSourceAssay;
import edu.project3.loggerAnalyzer.analyzer.assay.RequestAssay;
import edu.project3.loggerAnalyzer.analyzer.assay.ResponseVolumeAssay;
import edu.project3.loggerAnalyzer.analyzer.assay.TimeAssay;
import edu.project3.loggerAnalyzer.analyzer.config.NginxConfig;
import edu.project3.loggerAnalyzer.parser.NginxLog;
import edu.project3.loggerAnalyzer.provider.source.PathSourceMatcher;
import edu.project3.loggerAnalyzer.provider.source.Source;
import edu.project3.loggerAnalyzer.provider.source.UrlSource;
import edu.project3.loggerAnalyzer.report.LogsReporter;
import edu.project3.loggerAnalyzer.report.Report;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import picocli.CommandLine;
import static edu.project3.loggerAnalyzer.parser.NginxParser.parseLogFiles;
import static edu.project3.loggerAnalyzer.parser.NginxParser.parseLogLines;
import static edu.project3.loggerAnalyzer.provider.LogsProvider.findLogFilesInRootDirectory;
import static edu.project3.loggerAnalyzer.provider.LogsProvider.readAllLinesFrom;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x1row;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x2row;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x3row;
import static edu.project3.loggerAnalyzer.report.LogsReporter.createReport;

@SuppressWarnings({"MultipleStringLiterals"})
public class NginxAnalyzer {
    private static final int NUMBER_OF_TABLES = 4;
    private NginxConfig configuration;
    private List<Path> allNginxLogFiles;
    private List<NginxLog> allNginxLogItems;

    public NginxAnalyzer(String[] args) {
        configure(args);
        initLogItems();
    }

    public Report fullyAnalyze() {
        List<String> tables = new ArrayList<>(NUMBER_OF_TABLES);

        tables.add(getFileNamesNx1Table());
        tables.add(getMetricValue5x2Table());
        tables.add(getResourceCount6x2Table());
        tables.add(getStatusNameCount6x3Table());
        tables.add(getCategoryCountPercent6x3Table());
        tables.add(getTimeOfDayCountPercent6x3Table());

        LogsReporter.ReportFormat format = configuration.getFormat();
        return format != null
            ? createReport(tables, format)
            : createReport(tables, LogsReporter.ReportFormat.markdown);
    }

    private void configure(String[] args) {
        configuration = new NginxConfig();
        CommandLine commandLine = new CommandLine(configuration);
        commandLine.registerConverter(Source.class, NginxConfig::convert);
        commandLine.parseArgs(args);
    }

    private void initLogItems() {
        allNginxLogFiles = new ArrayList<>();
        Source source = configuration.getSource();

        if (source instanceof UrlSource urlSource) {
            allNginxLogFiles.add(Path.of(urlSource.getURL().getFile()));
            allNginxLogItems = parseLogLines(
                readAllLinesFrom(urlSource.getURL())
            );
        } else if (source instanceof PathSourceMatcher pathMatcherSource) {
            allNginxLogFiles.addAll(findLogFilesInRootDirectory(pathMatcherSource.getPathMatcher()));
            allNginxLogItems = parseLogFiles(allNginxLogFiles);
        }

        filterNginxLogItemsByOffsetDateTimeRange();
    }

    private void filterNginxLogItemsByOffsetDateTimeRange() {
        allNginxLogItems = allNginxLogItems.stream()
            .filter(this::isNginxLogItemInDateRange)
            .toList();
    }

    private boolean isNginxLogItemInDateRange(NginxLog item) {
        OffsetDateTime timeLocal = item.timeLocal();
        OffsetDateTime from = configuration.getFrom();
        OffsetDateTime to   = configuration.getTo();

        return (from == null || timeLocal.isAfter(from)) && (to == null || timeLocal.isBefore(to));
    }

    private String getFileNamesNx1Table() {
        return create1x1row("File name") + getFileNames();
    }

    private String getFileNames() {
        var builder = new StringBuilder();

        for (var path : allNginxLogFiles) {
            builder.append(create1x1row(path.getFileName().toString()));
        }

        return builder.toString();
    }

    private String getMetricValue5x2Table() {
        var info = new StringBuilder();

        String from = configuration.getFrom() != null ? configuration.getFrom().toString() : "-";
        String to   = configuration.getTo() != null ? configuration.getTo().toString() : "-";

        info.append(create1x2row("Metric", "Value"))
            .append(create1x2row("From date", from))
            .append(create1x2row("To date", to))
            .append(RequestAssay.analyze(allNginxLogItems))
            .append(ResponseVolumeAssay.analyze(allNginxLogItems));

        return info.toString();
    }

    private String getResourceCount6x2Table() {
        return create1x2row("Resource", "Count")
            + MostCommonSourceAssay.analyze(allNginxLogItems);
    }

    private String getStatusNameCount6x3Table() {
        return create1x3row("Status", "Name", "Count")
            + ResponseVolumeAssay.analyze(allNginxLogItems);
    }

    private String getCategoryCountPercent6x3Table() {
        return create1x3row("Category", "Count", "Percent")
            + HttpStatusAssay.analyze(allNginxLogItems);
    }

    private String getTimeOfDayCountPercent6x3Table() {
        return create1x3row("Time of day", "Count", "Percent")
            + TimeAssay.analyze(allNginxLogItems);
    }

}
