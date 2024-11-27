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
            등록
            명언3
            작가3
            """);
        assertThat(output)
            .contains("1번 명언이 등록되었습니다.")
            .contains("2번 명언이 등록되었습니다.")
            .contains("3번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록 명령어 : 입력된 명언들을 출력한다.")
    public void t7() {
        String output = AppTest.run("""
            등록
            명언1
            작가1
            등록
            명언2
            작가2
            목록
            """);
        assertThat(output)
            .contains("1번 명언이 등록되었습니다.")
            .contains("2번 명언이 등록되었습니다.")
            .contains("번호 / 작가 / 명언")
            .contains("----------------------")
            .contains("2 / 작가2 / 명언2")
            .contains("1 / 작가1 / 명언1");
    }

    @Test
    @DisplayName("목록 명령어 : 입력된 명언들을 출력한다.")
    public void t8() {
        String output = AppTest.run("""
            등록
            명언1
            작가1
            등록
            명언2
            작가2
            등록
            명언3
            작가3
            목록
            """);
        assertThat(output)
            .contains("번호 / 작가 / 명언")
            .contains("----------------------")
            .contains("3 / 작가3 / 명언3")
            .contains("2 / 작가2 / 명언2")
            .contains("1 / 작가1 / 명언1");
    }

    @Test
    @DisplayName("삭제 명령어 : 입력한 번호에 해당하는 명언이 삭제된다.")
    public void t9() {
        String output = AppTest.run("""
                등록
                명언1
                작가1
                등록
                명언2
                작가2
                삭제?id=1
                목록
            """);
        assertThat(output)
            .contains("2 / 작가2 / 명언2")
            .doesNotContain("1 / 작가1 / 명언1");
    }
}
