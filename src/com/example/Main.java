package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from EKS! App is running.");
        // Keep the app alive so the pod doesn't exit immediately
        try {
            while (true) {
                Thread.sleep(30_000);
                System.out.println("Still alive...");
            }
        } catch (InterruptedException e) {
            System.err.println("App interrupted, shutting down.");
            Thread.currentThread().interrupt();
        }
    }
}
