package edu.hw2.Task4;

public class Task4 {
    private Task4() {

    }

    public static CallingInfo getMethodsAndClasses() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String className;
        String methodName;
        className = stackTraceElements[stackTraceElements.length - 1].getClassName();
        methodName = stackTraceElements[stackTraceElements.length - 1].getMethodName();
        return new CallingInfo(className, methodName);
    }

    public record CallingInfo(String className, String methodName) {
    }
}
