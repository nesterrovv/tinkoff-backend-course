package edu.project3.loggerAnalyzer.provider.source;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class UrlSource implements Source {
    private final URL url;

    public UrlSource(String pattern) throws URISyntaxException, IllegalArgumentException, MalformedURLException {
        url = new URI(pattern).toURL();
    }

    public URL getURL() {
        return url;
    }

}
