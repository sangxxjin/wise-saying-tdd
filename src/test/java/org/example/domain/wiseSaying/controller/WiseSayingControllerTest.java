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
}
