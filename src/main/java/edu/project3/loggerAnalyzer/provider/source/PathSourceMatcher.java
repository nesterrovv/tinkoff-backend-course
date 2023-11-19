package edu.project3.loggerAnalyzer.provider.source;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

public final class PathSourceMatcher implements Source {

    private final PathMatcher pathMatcher;

    public PathSourceMatcher(String pattern) {
        String syntaxAndPattern = "glob:**/" + pattern;
        pathMatcher = FileSystems.getDefault().getPathMatcher(syntaxAndPattern);
    }

    public PathMatcher getPathMatcher() {
        return pathMatcher;
    }

}
