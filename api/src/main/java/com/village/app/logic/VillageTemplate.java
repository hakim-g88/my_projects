package com.village.app.logic;

import java.util.Date;

public class VillageTemplate {
    public String name;
    public Integer civilians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCivilians() {
        return civilians;
    }

    public void setCivilians(Integer civilians) {
        this.civilians = civilians;
    }

    public Village toVillage() {
        Village temp = new Village();
        temp.name = name;
        temp.civilians = civilians;
        temp.id = new Long(new Date().getTime()).toString();
        return temp;
    }
}
