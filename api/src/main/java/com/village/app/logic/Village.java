package com.village.app.logic;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Village {
    public String name;
    public String id;
    public Integer civilians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCivilians() {
        return civilians;
    }

    public void setCivilians(Integer civilians) {
        this.civilians = civilians;
    }

    public void save(String path, ObjectMapper mapper) throws IOException {
        mapper.writeValue(new File(path), this);
    }
}
