package org.example;

import java.util.Scanner;
import org.example.domain.system.controller.SystemController;

public class App {

    private final Scanner scanner;
    private final SystemController systemController;

    public App(Scanner scanner) {
        this.scanner = scanner;
        this.systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.println("명령) ");
            String cmd = scanner.nextLine();
            if ("종료".equals(cmd)) {
                systemController.actionExit();
                break;
            }
            if ("등록".equals(cmd)) {
                System.out.println("명언 : ");
                System.out.println("작가 : ");
            }
        }
    }
}
