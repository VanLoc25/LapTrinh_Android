package com.example.habitcheckcalendar;

// Event.java
public class Event {
    private String name;
    private boolean isChecked;

    public Event(String name) {
        this.name = name;
        this.isChecked = false;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
