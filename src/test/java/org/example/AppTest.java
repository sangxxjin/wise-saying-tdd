package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import org.example.domain.wiseSaying.repository.WiseSayingFileRepository;
import org.example.standard.uttil.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {

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

    public static String run(String input) {
        input = input.stripIndent().trim();
        Scanner scanner = TestUtil.getScanner(input + "\n종료");
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();
        App app = new App(scanner);
        app.run();
        String output = outputStream.toString();
        TestUtil.clearSetOutToByteArray(outputStream);
        return output;
    }

    public static void dropTables() {
        WiseSayingFileRepository.dropTable();
    }

}
