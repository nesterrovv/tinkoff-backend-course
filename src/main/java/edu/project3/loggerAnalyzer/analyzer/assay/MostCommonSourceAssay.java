package edu.project3.loggerAnalyzer.analyzer.assay;

import edu.project3.loggerAnalyzer.parser.NginxLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x2row;

public final class MostCommonSourceAssay {

    private MostCommonSourceAssay() {}

    private static final int TOP = 5;
    private static final int TOKENS_NUMBER = 3;

    public static String analyze(List<NginxLog> nginxLogItems) {
        Map<String, String> top5resources = nginxLogItems.stream()
            .map(NginxLog::request)
            .map(MostCommonSourceAssay::parseResourceFromRequest)
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
        top5resources.forEach((resource, count) ->
            builder.append(create1x2row(resource, count))
        );

        return builder.toString();
    }

    private static String parseResourceFromRequest(String request) {
        String[] tokens = request.split(" ");
        return (tokens.length == TOKENS_NUMBER) ? tokens[1] : null;
    }

}
