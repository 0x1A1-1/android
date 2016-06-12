package com.example.practiceapp;

import java.io.Serializable;

/**
 * Created by cigarent on 6/12/16.
 */
public class Show implements Serializable {

    private String name, intro;

    public Show(String name, String intro) {
        this.name = name;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
