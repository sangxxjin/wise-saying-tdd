package org.example.standard.uttil;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestUtilTest {

    @Test
    @DisplayName("TestUtil.getScanner()")
    public void t1() {
        Scanner scanner = TestUtil.getScanner("""
            등록
            명언1
            작가1
            """.stripIndent().trim());

        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String authpr = scanner.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("명언1");
        assertThat(authpr).isEqualTo("작가1");
    }
    @Test
    @DisplayName("TestUtil.setOutToByteArray()")
    public void t2() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        System.out.println("2 / 명언2 / 작가2");
        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray(byteArrayOutputStream);
        assertThat(out).isEqualTo("2 / 명언2 / 작가2");
        System.out.println("이제는 화면에 출력됩니다.");

    }
}
