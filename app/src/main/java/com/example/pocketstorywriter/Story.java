package com.example.pocketstorywriter;

public class Story {
    public String title;
    public String preview;

    public Story(String title, String preview) {
        this.title = title;
        this.preview = preview;
    }

    public String getTitle() {
        return title;
    }

    public String getPreview() {
        return preview;
    }
}