package com.shushanfx.guava.base;

import com.google.common.collect.ComparisonChain;

/**
 * Created by dengjianxin on 2014/9/18.
 */
public class ComparisonBean implements Comparable<ComparisonBean>{
    private String name;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComparisonBean(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int compareTo(ComparisonBean o) {
        return ComparisonChain.start()
                .compare(this.level, o.level)
                .compare(this.name, o.name)
                .result();
    }
}
