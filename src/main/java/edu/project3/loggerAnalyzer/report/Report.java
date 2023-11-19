package edu.project3.loggerAnalyzer.report;

public abstract class Report {

    private final String report;

    public Report(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }

}
