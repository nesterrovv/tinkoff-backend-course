package edu.hw2.task4;

import java.util.logging.Logger;

public final class CallingInfoManager {

    private static final Logger LOGGER = Logger.getLogger("LOGGER");

    private CallingInfoManager() {}

    public static CallingInfo callingInfo() {
        StackTraceElement info = new Throwable().getStackTrace()[1];
        return new CallingInfo(info.getClassName(), info.getMethodName());
    }

}
