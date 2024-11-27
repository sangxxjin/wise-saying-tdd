package org.example.domain.wiseSaying.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.example.domain.wiseSaying.entity.WiseSaying;
import org.example.standard.Util;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class wiseSayingFileRepositoryTest {

    private final WiseSayingRepository wiseSayingRepository = new WiseSayingFileRepository();

    @BeforeAll
    public static void beforeAll() {
        Util.file.rmdir("db");
        Util.file.mkdir("db");
    }

    @AfterAll
    public static void afterAll() {
        Util.file.rmdir("db");
    }

    @Test
    @DisplayName("명언 저장")
    public void t1() {
        WiseSaying wiseSaying = new WiseSaying(0, "꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        wiseSayingRepository.save(wiseSaying);
        String filePath = "db/test/wiseSaying/1.json";
        assertThat(
            Util.file.exists(filePath)
        ).isTrue();
        String jsonStr = Util.file.get(filePath, "");
        Map<String, Object> wiseSayingMap = Util.json.toMap(jsonStr);
        WiseSaying wiseSayingRestored = new WiseSaying(wiseSayingMap);
        assertThat(wiseSayingRestored).isEqualTo(wiseSaying);
    }
}
