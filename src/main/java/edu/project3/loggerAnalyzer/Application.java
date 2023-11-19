package edu.project3.loggerAnalyzer;

import edu.project3.loggerAnalyzer.analyzer.NginxAnalyzer;
import edu.project3.loggerAnalyzer.report.Report;
import static edu.project3.loggerAnalyzer.typeManager.LogsTypeManager.getNginxLogsAnalyzer;

public final class Application {
    private Application() {}

    @SuppressWarnings({"RegexpSinglelineJava"})
    public static void main(String[] args) {
        NginxAnalyzer nginxLogAnalyzer = getNginxLogsAnalyzer(args);
        Report result = nginxLogAnalyzer.fullyAnalyze();
        System.out.println(result.getReport());
    }

}
