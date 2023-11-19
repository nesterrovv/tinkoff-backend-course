package edu.project3.loggerAnalyzer.analyzer.assay;

import edu.project3.loggerAnalyzer.parser.NginxLog;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x3row;

public final class TimeAssay {

    private TimeAssay() {}

    private static final double FULL_PROBABILITY = 100.0;

    public static String analyze(List<NginxLog> nginxLogItems) {
        Map<String, Long> statusCounts = nginxLogItems.stream()
            .collect(Collectors.groupingBy(
                TimeAssay::getTimeOfDayCategory,
                Collectors.counting()
            )
        );
        Locale locale = Locale.forLanguageTag("ru-RU");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        DecimalFormat df = new DecimalFormat("#.##", symbols);

        var builder = new StringBuilder();
        for (Map.Entry<String, Long> entry : statusCounts.entrySet()) {
            String timeOfDay = entry.getKey();
            long count = entry.getValue();
            double percent = (count * FULL_PROBABILITY) / nginxLogItems.size();

            builder.append(create1x3row(timeOfDay, Long.toString(count), df.format(percent)));
        }

        return builder.toString();
    }

    @SuppressWarnings({"MagicNumber", "ReturnCount"})
    private static String getTimeOfDayCategory(NginxLog nginxLogItem) {
        int hour = nginxLogItem.timeLocal().getHour();
        if (hour >= 5 && hour < 12) {
            return "Morning";
        } else if (hour >= 12 && hour < 19) {
            return "Day";
        } else if (hour >= 18) {
            return "Evening";
        } else {
            return "Night";
        }
    }

}
