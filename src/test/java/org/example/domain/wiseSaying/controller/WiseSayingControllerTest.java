package org.example.domain.wiseSaying.controller;


import static org.assertj.core.api.Assertions.assertThat;

import org.example.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WiseSayingControllerTest {


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

    @Test
    @DisplayName("등록이 완료되면 명언 번호가 출력된다..")
    public void t5() {
        String output = AppTest.run("""
            등록
            명언1
            작가1
            """);
        assertThat(output)
            .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("매번 생성되는 명언번호는 1씩 증가 한다.")
    public void t6() {
        String output = AppTest.run("""
            등록
            명언1
            작가1
            등록
            명언2
            작가2
            """);
        assertThat(output)
            .contains("1번 명언이 등록되었습니다.")
            .contains("2번 명언이 등록되었습니다.");
    }
}
