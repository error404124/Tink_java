package edu.hw2.Task4;

public class Task4 {
    static final int NUMBER = 2;

    private Task4() {

    }

    public static CallingInfo getMethodsAndClasses() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String className;
        String methodName;
        className = stackTraceElements[NUMBER].getClassName();
        methodName = stackTraceElements[NUMBER].getMethodName();
        return new CallingInfo(className, methodName);
    }

    public record CallingInfo(String className, String methodName) {
    }
}
