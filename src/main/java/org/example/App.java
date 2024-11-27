package org.example;

import java.util.Scanner;
import org.example.domain.system.controller.SystemController;
import org.example.domain.wiseSaying.controller.WiseSayingController;

public class App {

    private final Scanner scanner;
    private final SystemController systemController;
    private final WiseSayingController wiseSayingController;

    public App(Scanner scanner) {
        this.scanner = scanner;
        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController(scanner);
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.println("명령) ");
            String cmd = scanner.nextLine();
            String[] cmdBits = cmd.split("\\?");
            String actionName = cmdBits[0];
            if ("종료".equals(cmd)) {
                systemController.actionExit();
                break;
            }
            if ("등록".equals(cmd)) {
                wiseSayingController.actionAdd();
            }
            if ("목록".equals(cmd)) {
                wiseSayingController.actionList();
            }
            if ("삭제".equals(actionName)) {
                wiseSayingController.actionDelete(cmd);
            }
        }
    }
}
