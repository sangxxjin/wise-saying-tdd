package org.example.domain.wiseSaying.repository;


import java.util.List;
import java.util.Optional;
import org.example.domain.wiseSaying.entity.WiseSaying;

public interface WiseSayingRepository {
    WiseSaying save(WiseSaying wiseSaying);

    List<WiseSaying> findAll();

    boolean deleteById(int id);

    Optional<WiseSaying> findById(int id);
}