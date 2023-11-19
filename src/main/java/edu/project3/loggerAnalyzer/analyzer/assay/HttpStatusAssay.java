package edu.project3.loggerAnalyzer.analyzer.assay;

import edu.project3.loggerAnalyzer.parser.NginxLog;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x3row;

public final class HttpStatusAssay {

    private HttpStatusAssay() {}

    private static final double FULL_PROBABILITY = 100.0;

    public static String analyze(List<NginxLog> nginxLogItems) {
        Map<String, Long> statusCounts = nginxLogItems.stream()
            .collect(Collectors.groupingBy(
                HttpStatusAssay::getStatusCategory,
                Collectors.counting()
            ));
        Locale locale = Locale.forLanguageTag("ru-RU");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        DecimalFormat df = new DecimalFormat("#.##", symbols);

        var builder = new StringBuilder();
        for (Map.Entry<String, Long> entry : statusCounts.entrySet()) {
            String category = entry.getKey();
            long count = entry.getValue();
            double percent = (count * FULL_PROBABILITY) / nginxLogItems.size();

            builder.append(create1x3row(category, Long.toString(count), df.format(percent)));
        }

        return builder.toString();
    }

    @SuppressWarnings({"ReturnCount", "MagicNumber"})
    private static String getStatusCategory(NginxLog nginxLogItem) {
        int statusCode = nginxLogItem.status();
        if (statusCode >= 100 && statusCode < 200) {
            return "Informational";
        } else if (statusCode >= 200 && statusCode < 300) {
            return "Successful";
        } else if (statusCode >= 300 && statusCode < 400) {
            return "Redirection";
        } else if (statusCode >= 400 && statusCode < 500) {
            return "Client Errors";
        } else if (statusCode >= 500 && statusCode < 600) {
            return "Server Errors";
        } else {
            return "Unknown";
        }
    }

}
