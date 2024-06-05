package com.example.exercisefinal;

public class exercise_list {

    private Integer image;
    private String text;

    private String pitch;

    private Integer page_position;

    public exercise_list(Integer image, String text, String pitch, Integer page_position) {
        this.image = image;
        this.text = text;
        this.pitch = pitch;
        this.page_position = page_position;
    }
    public exercise_list(Integer image, String text, Integer page_position) {
        this.image = image;
        this.text = text;
        this.page_position = page_position;
    }

    public Integer getPage_position() {
        return page_position;
    }

    public void setPage_position(Integer page_position) {
        this.page_position = page_position;
    }

    public exercise_list(Integer image, String text, String pitch) {
        this.image = image;
        this.text = text;
        this.pitch = pitch;
    }

    public exercise_list(Integer image, String text) {
        this.image = image;
        this.text = text;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }
}
