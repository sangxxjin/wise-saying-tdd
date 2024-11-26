package org.example.domain.wiseSaying.controller;


import static org.assertj.core.api.Assertions.assertThat;

import org.example.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WiseSayingControllerTest {


    @Test
    @DisplayName("== 명언 앱 ==")
    public void t1() {
        String output = AppTest.run("");
        assertThat(output)
            .contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) ")
    public void t2() {
        String output = AppTest.run("""
            목록
            """);
        assertThat(output)
            .contains("명령) ");
    }

    @Test
    @DisplayName("명령을 2번 이상 입력할 수 있어야합니다.")
    public void t3() {
        String output = AppTest.run("""
            목록
            목록
            """);
        String[] split = output.split("명령\\) ");
        assertThat(split).hasSize(4);
    }

    @Test
    @DisplayName("등록을 입력하면 내용과 작가를 입력 받는다.")
    public void t4() {
        String output = AppTest.run("""
            등록
            명언1
            작가1
            """);
        assertThat(output)
            .contains("명언 : ")
            .contains("작가 : ");
    }
}
