package com.example.danhdaungaylam;

import java.util.List;

public class WeekAdapter extends RecyclerView.Adapter<WeekAdapter.WeekViewHolder> {

    private List<String> daysList;
    private List<String> weekDaysList;

    public WeekAdapter(List<String> weekDaysList, List<String> daysList) {
        this.weekDaysList = weekDaysList;
        this.daysList = daysList;
    }

    @NonNull
    @Override
    public WeekViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.week_day_item, parent, false);
        return new WeekViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekViewHolder holder, int position) {
        holder.dayTextView.setText(weekDaysList.get(position));
        holder.dateTextView.setText(daysList.get(position));
    }

    @Override
    public int getItemCount() {
        return daysList.size();
    }

    public static class WeekViewHolder extends RecyclerView.ViewHolder {
        TextView dayTextView;
        TextView dateTextView;

        public WeekViewHolder(@NonNull View itemView) {
            super(itemView);
            dayTextView = itemView.findViewById(R.id.dayTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }
}


