package org.example.standard.uttil;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.example.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JsonUtilTest {

    @Test
    @DisplayName("Map을 Json으로 바꿀 수 있다.(필드 1개)")
    public void t1() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "이름");
        String jsonStr = Util.json.toString(map);
        assertThat(jsonStr).isEqualTo("""
                {
                "name": "이름"
                }
                """.stripIndent().trim());
    }
    @Test
    @DisplayName("Map을 JSON으로 바꿀 수 있다.(필드 2개)")
    public void t2() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "이름");
        map.put("gender", "남자");
        String jsonStr = Util.json.toString(map);
        assertThat(jsonStr).isEqualTo("""
                {
                    "name": "이름",
                    "gender": "남자"
                }
                """.stripIndent().trim());
    }

}
