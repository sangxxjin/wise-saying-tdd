package org.example.standard.uttil;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @Test
    @DisplayName("파일 생성")
    public void t1() {
        String filePath = "test.txt";
        Util.file.touch(filePath);
        assertThat(Util.file.exists(filePath)).isTrue;

    }

}
