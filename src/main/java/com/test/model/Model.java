package com.test.model;

import java.io.Serializable;

/**
 * Created by litr on 2016/12/18.
 */
public class Model implements Serializable {
    private static final long serialVersionUID = 2412880874745818153L;
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

