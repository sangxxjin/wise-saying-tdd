package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {
//        lab1();
//        lab2();
//        lab3();
        lab4();
    }

    private static void lab1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("명령)");
        String cmd = scanner.nextLine().trim();
        System.out.println("입력한 명령: " + cmd);
    }

    private static void lab2() {
        InputStream in = new ByteArrayInputStream("안녕\n잘가".getBytes());
        Scanner scanner = new Scanner(in);
        System.out.println("명령)");
        String cmd = scanner.nextLine().trim();
        System.out.println("입력한 명령: " + cmd);
        cmd = scanner.nextLine().trim();
        System.out.println("입력한 명령: " + cmd);
    }

    private static void lab3() {
        System.out.println(" == 시작 == ");
        System.out.println("안녕하세요");
        System.out.println("끝");
    }

    private static void lab4() throws IOException {
        System.out.println(" == 시작 == ");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        System.out.println("안녕하세요");
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("끝");
        System.out.println("출력: " + output.toString());
        output.close();

    }
}