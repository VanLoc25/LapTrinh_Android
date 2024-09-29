package com.example.habitcheckcalendar;

public class Habit {
    private String name;
    private String date; // Date in format yyyy-MM-dd
    private boolean isCompleted;

    public Habit(String name, String date, boolean completed) {
        this.name = name;
        this.date = date;
        this.isCompleted = completed;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { this.isCompleted = completed; }
}
