package edu.project3.loggerAnalyzer.analyzer.assay;

import edu.project3.loggerAnalyzer.parser.NginxLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x3row;

public final class MostCommonResponseCodeAssay {

    private MostCommonResponseCodeAssay() {}

    private static final int TOP = 5;

    public static String analyze(List<NginxLog> nginxLogItems) {
        Map<String, String> top5codes = nginxLogItems.stream()
            .map(item -> Integer.toString(item.status()))
            .collect(
                Collectors.groupingBy(
                    Function.identity(), Collectors.counting()
                )
            )
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(TOP)
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> entry.getValue().toString(),
                    (e1, e2) -> e1,
                    LinkedHashMap::new
                )
            );

        var builder = new StringBuilder();
        top5codes.forEach((status, count) ->
            builder.append(
                create1x3row(status, getStatusName(status), count)
            )
        );

        return builder.toString();
    }

    private static String getStatusName(String statusCode) {
        return switch (statusCode) {
            case "200" -> "OK";
            case "201" -> "Created";
            case "204" -> "No Content";
            case "400" -> "Bad Request";
            case "401" -> "Unauthorized";
            case "403" -> "Forbidden";
            case "404" -> "Not Found";
            case "500" -> "Internal Server Error";
            default -> "Unknown";
        };
    }

}
