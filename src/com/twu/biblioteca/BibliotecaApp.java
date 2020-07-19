package com.twu.biblioteca;

import java.util.Map;
import java.util.Scanner;

public class BibliotecaApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final Menu menu = new Menu(DataProvider.getMenuOptions(DataProvider.getLibraryInstance()));

    public static void main(String[] args) {
        welcome();
        mainLoop();
    }

    private static void welcome() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    private static void mainLoop() {
        while (true) {
            showMenu();
            menu.runOption(sc.next());
        }
    }

    private static void showMenu() {
        System.out.println("Please select an option:");
        menu.getOptions().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.printf("%2s - %s\n", entry.getKey(), entry.getValue().getDescription()));
    }
}
