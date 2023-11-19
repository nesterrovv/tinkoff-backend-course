package edu.project3.loggerAnalyzer.parser;

import java.net.InetAddress;
import java.net.URI;
import java.time.OffsetDateTime;

public record NginxLog(
    InetAddress remoteAddress,
    String remoteUser,
    OffsetDateTime timeLocal,
    String request,
    int status,
    long bodyBytesSent,
    URI httpReferer,
    String httpUserAgent) {}
