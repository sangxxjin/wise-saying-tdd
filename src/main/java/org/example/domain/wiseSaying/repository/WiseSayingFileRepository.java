package org.example.domain.wiseSaying.repository;


import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Optional;
import org.example.domain.wiseSaying.entity.WiseSaying;
import org.example.standard.Util;

public class WiseSayingFileRepository implements WiseSayingRepository {

    private int lastId;

    public static String getTableDirPath() {
        return "db/test/wiseSaying";
    }

    public static String getRowFilePath(int id) {
        return getTableDirPath() + "/" + id + "json";
    }

    public WiseSayingFileRepository() {
        this.lastId = 0;
    }

    public static String getLastIdPath() {
        return getTableDirPath() + "/lastId.txt";
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        boolean isNew = wiseSaying.isNew();
        if (isNew) {
            wiseSaying.setId(getLastId() + 1);
        }
        String jsonStr = wiseSaying.toJsonStr();
        Util.file.set(getRowFilePath(wiseSaying.getId()), jsonStr);
        if (isNew) {
            setLastId(wiseSaying.getId());
        }
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        try {
            return Util.file.walkRegularFiles(
                    getTableDirPath(),
                    "\\d+\\.json"
                )
                .map(path -> Util.file.get(path.toString(), ""))
                .map(WiseSaying::new)
                .toList();
        } catch (NoSuchFileException e) {
            return List.of();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteById(int id) {
        return Util.file.delete(getRowFilePath(id));
    }

    public Optional<WiseSaying> findById(int id) {
        String filePath = getRowFilePath(id);
        if (Util.file.notExists(filePath)) {
            return Optional.empty();
        }
        String jsonStr = Util.file.get(filePath, "");
        if (jsonStr.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(new WiseSaying(jsonStr));
    }

    public int getLastId() {
        return Util.file.getAsInt(getLastIdPath(), 0);
    }

    private void setLastId(int id) {
        Util.file.set(getLastIdPath(), id);
    }
}