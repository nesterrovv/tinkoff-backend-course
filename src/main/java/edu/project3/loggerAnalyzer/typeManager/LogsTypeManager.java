package edu.project3.loggerAnalyzer.typeManager;

import edu.project3.loggerAnalyzer.analyzer.NginxAnalyzer;

public final class LogsTypeManager {

    private LogsTypeManager() {}

    public static NginxAnalyzer getNginxLogsAnalyzer(String[] args) {
        return new NginxAnalyzer(args);
    }

}
