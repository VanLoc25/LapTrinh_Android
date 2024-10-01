package com.example.habitcheckcalendar_v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Habit {
    private String name;
    private List<Boolean> completedStatus; // Trạng thái hoàn thành của thói quen trong từng ngày.

    public Habit(String name) {
        this.name = name;
        this.completedStatus = new ArrayList<>(Collections.nCopies(7, false)); // Ban đầu chưa hoàn thành.
    }

    public String getName() {
        return name;
    }

    public List<Boolean> getCompletedStatus() {
        return completedStatus;
    }

    public void setCompletedStatus(int dayIndex, boolean isCompleted) {
        this.completedStatus.set(dayIndex, isCompleted);
    }
}
