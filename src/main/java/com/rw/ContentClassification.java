package com.rw;

public class ContentClassification {
    private String type;

    public ContentClassification(String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return type;
    }
}
