package org.example;

import java.util.Scanner;
import org.example.global.app.App;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new App(scanner).run();
        scanner.close();
    }
}