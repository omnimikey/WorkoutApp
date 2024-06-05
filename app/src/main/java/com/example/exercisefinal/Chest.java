package com.example.exercisefinal;

import java.io.Serializable;

public class Chest implements Serializable {

    private String name;
    private Integer image;
    private Integer reps;
    private Integer sets;
    private Integer duration;
    private Integer pounds;
    private Integer id;

    private Long extimer;

    private Boolean state;

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Chest(String name, Integer image, Integer reps, Integer sets, Integer duration, Integer pounds, Integer id, Long extimer, Boolean state) {
        this.name = name;
        this.image = image;
        this.reps = reps;
        this.sets = sets;
        this.duration = duration;
        this.pounds = pounds;
        this.id = id;
        this.extimer = extimer;
        this.state = state;
    }

    public Chest(String name, Integer image, Integer reps, Integer sets, Integer duration, Integer pounds, Integer id, Long extimer) {
        this.name = name;
        this.image = image;
        this.reps = reps;
        this.sets = sets;
        this.duration = duration;
        this.pounds = pounds;
        this.id = id;
        this.extimer = extimer;
    }

    public Chest(String name, Integer image, Integer reps, Integer sets, Integer duration, Integer pounds) {
        this.name = name;
        this.image = image;
        this.reps = reps;
        this.sets = sets;
        this.duration = duration;
        this.pounds = pounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPounds() {
        return pounds;
    }

    public void setPounds(Integer pounds) {
        this.pounds = pounds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getExtimer() {
        return extimer;
    }

    public void setExtimer(Long extimer) {
        this.extimer = extimer;
    }

    @Override
    public String toString() {
        return "Chest{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", reps=" + reps +
                ", sets=" + sets +
                ", duration=" + duration +
                ", pounds=" + pounds +
                '}';
    }
}
