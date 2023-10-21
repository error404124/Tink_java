package edu.hw2.Task4;

public class Task4 {
    private Task4() {

    }

    static StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

    public static CallingInfo getMethodsAndClasses() {
        String className;
        String methodName;
        for (int i = stackTraceElements.length - 1; i >= 2; --i) {
            className = stackTraceElements[i].getClassName();
            methodName = stackTraceElements[i].getMethodName();
            return new CallingInfo(className, methodName);
        }
        return null;
    }

    public record CallingInfo(String className, String methodName) {
    }
}
