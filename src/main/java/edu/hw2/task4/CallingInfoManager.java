package edu.hw2.task4;

public final class CallingInfoManager {

    private CallingInfoManager() {}

    public static CallingInfo callingInfo(Exception exception) {
        if (exception == null) {
            return null;
        }
        StackTraceElement[] stackTrace = exception.getStackTrace();
        if (stackTrace.length > 1) {
            StackTraceElement info = stackTrace[1];
            return new CallingInfo(info.getClassName(), info.getMethodName());
        }
        return null;
    }

}





