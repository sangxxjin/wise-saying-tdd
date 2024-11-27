package org.example.standard.uttil;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.example.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JsonUtilTest {

    @Test
    @DisplayName("Map을 Json으로 바꿀 수 있다.")
    public void t1() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","dlfma");
        String jsonStr = Util.json.toString(map);
        assertThat(jsonStr).isEqualTo("""
                {
                "name": "이름"
                }
                """.stripIndent());
    }

}
