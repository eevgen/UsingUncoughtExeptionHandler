package org.example;

public class Main {

    private static final String MESSAGE_FOR_UNCAUGHT_EXCEPTION_HANDLER_TEMPLATE = "Exception's message is '%s' in thread '%s'";
    private static final String MESSAGE_IN_UNCAUGHT_EXCEPTION = "This exception is fake for learning";

    public static void main(String[] args) {

        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (thread, exception) -> {
            System.out.printf(MESSAGE_FOR_UNCAUGHT_EXCEPTION_HANDLER_TEMPLATE, exception.getMessage(), thread.getName());
        };

        Thread thread = new Thread(new TaskWithException());
        thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        thread.start();

    }

    final static class TaskWithException implements Runnable {
        @Override
        public void run() {
            throw new RuntimeException(MESSAGE_IN_UNCAUGHT_EXCEPTION);
        }
    }
}