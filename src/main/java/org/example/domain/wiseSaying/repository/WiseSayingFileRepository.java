package org.example.domain.wiseSaying.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.example.domain.wiseSaying.entity.WiseSaying;
import org.example.standard.Util;

public class WiseSayingFileRepository implements WiseSayingRepository {

    private final List<WiseSaying> wiseSayings;
    private int lastId;

    public static String getTableDirPath() {
        return "db/test/wiseSaying";
    }

    public static String getRowFilePath(int id) {
        return getTableDirPath() + "/" + id + "json";
    }

    public WiseSayingFileRepository() {
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (!wiseSaying.isNew()) {
            return wiseSaying;
        }

        wiseSaying.setId(++lastId);
        Map<String, Object> wiseSayingMap = wiseSaying.toMap();
        String jsonStr = Util.json.toString(wiseSayingMap);
        Util.file.set(getRowFilePath(wiseSaying.getId()), jsonStr);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean deleteById(int id) {
        return Util.file.delete(getRowFilePath(id));
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings.stream()
            .filter(wiseSaying -> wiseSaying.getId() == id)
            .findFirst();
    }
}