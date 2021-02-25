package com.sprinklebit.entity.input;

public class Street {
    public int start;
    public int end;
    public String name;
    public int length;

    public Street(int start, int end, String name, int length) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.length = length;
    }
}
