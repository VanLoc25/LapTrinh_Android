package com.example.dc;

import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {
    private List<Habit> habitList;

    public HabitAdapter(List<Habit> habitList) {
        this.habitList = habitList;
    }

    public HabitAdapter(List<Habit> habitList) {
    }

    @Override
    public HabitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new HabitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HabitViewHolder holder, int position) {
        Habit habit = habitList.get(position);
        holder.textView.setText(habit.getName());
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    public void notifyDataSetChanged() {
    }

    class HabitViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        HabitViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}

