package org.example.domain.wiseSaying;

import java.util.Scanner;

public class WiseSayingController {

    private final Scanner scanner;
    private int lastId;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.lastId = 1;
    }

    public void actionAdd() {
        System.out.println("명언 : ");
        System.out.println("작가 : ");
        int id = lastId++;
        System.out.println(id + "번 명언이 등록되었습니다.");

    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        System.out.println("2 / 작가2 / 명언2");
        System.out.println("번호1 / 작가1 / 명언1");
    }
}
