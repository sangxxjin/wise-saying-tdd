package org.example.domain.wiseSaying.controller;


import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import org.example.standard.uttil.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WiseSayingControllerTest {


    @Test
    @DisplayName("== 명언 앱 ==")
    public void t1() {
        Scanner scanner = TestUtil.getScanner("종료");
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        App app = new App(scanner);
        app.run();

        String output = outputStream.toString();

        TestUtil.clearSetOutToByteArray(outputStream);

        assertThat(output.toString())
            .contains("== 명언 앱 ==");
    }
}
