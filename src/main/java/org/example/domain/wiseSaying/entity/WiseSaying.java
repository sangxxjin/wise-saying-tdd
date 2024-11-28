package org.example.domain.wiseSaying.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.standard.Util;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class WiseSaying {

    private int id;
    private String content;
    private String author;

    public WiseSaying(Map<String, Object> map) {
        this.id = (int) map.get("id");
        this.content = (String) map.get("content");
        this.author = (String) map.get("author");
    }

    public WiseSaying(String jsonStr) {
        this(Util.json.toMap(jsonStr));
    }

    public boolean isNew() {
        return id == 0;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("content", content);
        map.put("author", author);
        return map;
    }

    public String toJsonStr() {
        return Util.json.toString(toMap());
    }
}
