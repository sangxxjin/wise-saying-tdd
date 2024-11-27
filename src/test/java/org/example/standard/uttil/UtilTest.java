package org.example.standard.uttil;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    @DisplayName("파일 생성")
    public void t1() {
        String filePath = "test.txt";
        Util.file.touch(filePath);
        assertThat(Util.file.exists(filePath)).isTrue();
    }

    @Test
    @DisplayName("파일의 내용을 수정할 수 있고, 읽을 수 있다.")
    public void t2() {
        String filePath = "test.txt";
        Util.file.set(filePath, "내용");
        assertThat(
            Util.file.get(filePath, "")
        ).isEqualTo("내용");
    }

}
