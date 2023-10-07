package org.example;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.listFilesInDirectory("/Users");
        System.out.println("------------");
        System.out.println("-----END----");
        System.out.println("------------");
        fileManager.sortFilesInDirectory("/Users");
    }
}