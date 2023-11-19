package edu.project3.loggerAnalyzer.analyzer.assay;

import edu.project3.loggerAnalyzer.parser.NginxLog;
import java.util.List;
import static edu.project3.loggerAnalyzer.report.LogsReporter.create1x2row;

public final class RequestAssay {

    private RequestAssay() {}

    private static final String HEADER = "Total requests";

    public static String analyze(List<NginxLog> nginxLogItems) {
        return create1x2row(HEADER, Integer.toString(nginxLogItems.size()));
    }

}
