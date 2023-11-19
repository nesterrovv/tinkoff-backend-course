package edu.project3.loggerAnalyzer.analyzer.assay;

import edu.project3.loggerAnalyzer.parser.NginxLog;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x2row;

public final class ResponseVolumeAssay {

    private ResponseVolumeAssay() {}

    private static final String HEADER = "Average server response";

    public static String analyze(List<NginxLog> nginxLogItems) {
        double averageResponse = nginxLogItems.stream()
            .mapToLong(NginxLog::bodyBytesSent)
            .average()
            .orElse(0.0
        );
        Locale locale = Locale.forLanguageTag("ru-RU");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        String formattedValue = df.format(averageResponse);
        return create1x2row(HEADER, formattedValue);
    }

}
