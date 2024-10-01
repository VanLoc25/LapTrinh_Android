package com.example.habitcheckcalendar_v1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {
    private List<Habit> habitList;

    public HabitAdapter(List<Habit> habitList) {
        this.habitList = habitList;
    }

    @NonNull
    @Override
    public HabitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_habit, parent, false);
        return new HabitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitViewHolder holder, int position) {
        Habit habit = habitList.get(position);
        holder.habitName.setText(habit.getName());

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            holder.checkBoxes[i].setChecked(habit.getCompletedStatus().get(i));
            holder.checkBoxes[i].setOnClickListener(v -> {
                habit.setCompletedStatus(finalI, holder.checkBoxes[finalI].isChecked());
                // Lưu trạng thái vào SharedPreferences hoặc database nếu cần.
            });
        }
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    public static class HabitViewHolder extends RecyclerView.ViewHolder {
        TextView habitName;
        CheckBox[] checkBoxes = new CheckBox[7]; // 7 ô checkbox cho các ngày

        public HabitViewHolder(@NonNull View itemView) {
            super(itemView);
            habitName = itemView.findViewById(R.id.habitName);
            checkBoxes[0] = itemView.findViewById(R.id.checkboxMonday);
            checkBoxes[1] = itemView.findViewById(R.id.checkboxTuesday);
            checkBoxes[2] = itemView.findViewById(R.id.checkboxWednesday);
            checkBoxes[3] = itemView.findViewById(R.id.checkboxThursday);
            checkBoxes[4] = itemView.findViewById(R.id.checkboxFriday);
            checkBoxes[5] = itemView.findViewById(R.id.checkboxSaturday);
            checkBoxes[6] = itemView.findViewById(R.id.checkboxSunday);
        }
    }

    private Activity itemView;
    CheckBox mondayCheckBox = itemView.findViewById(R.id.checkboxMonday);
    CheckBox tuesdayCheckBox = itemView.findViewById(R.id.checkboxTuesday);
// và các checkbox khác...

}

