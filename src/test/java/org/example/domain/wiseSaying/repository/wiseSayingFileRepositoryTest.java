package org.example.domain.wiseSaying.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.example.domain.wiseSaying.entity.WiseSaying;
import org.example.standard.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class wiseSayingFileRepositoryTest {

    private final WiseSayingRepository wiseSayingRepository = new WiseSayingFileRepository();

    @BeforeEach
    public void beforeEach() {
        Util.file.rmdir(WiseSayingFileRepository.getTableDirPath());
    }

    @AfterEach
    public void afterEach() {
        Util.file.rmdir(WiseSayingFileRepository.getTableDirPath());
    }

    @Test
    @DisplayName("명언 저장")
    public void t1() {
        WiseSaying wiseSaying = new WiseSaying(0, "꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        wiseSayingRepository.save(wiseSaying);
        Optional<WiseSaying> opWiseSaying = wiseSayingRepository.findById(wiseSaying.getId());
        assertThat(
            opWiseSaying.get()
        ).isEqualTo(wiseSaying);
    }

    @Test
    @DisplayName("명언 삭제")
    public void t2() {
        WiseSaying wiseSaying = new WiseSaying(0, "꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        wiseSayingRepository.save(wiseSaying);
        wiseSayingRepository.deleteById(wiseSaying.getId());
        String filePath = WiseSayingFileRepository.getRowFilePath(wiseSaying.getId());
        assertThat(
            Util.file.exists(filePath)
        ).isFalse();
    }

    @Test
    @DisplayName("명언 단건조회")
    public void t3() {
        WiseSaying wiseSaying = new WiseSaying(0, "꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        wiseSayingRepository.save(wiseSaying);
        Optional<WiseSaying> opWiseSaying = wiseSayingRepository.findById(wiseSaying.getId());
        assertThat(
            opWiseSaying.get()
        ).isEqualTo(wiseSaying);
    }
}
