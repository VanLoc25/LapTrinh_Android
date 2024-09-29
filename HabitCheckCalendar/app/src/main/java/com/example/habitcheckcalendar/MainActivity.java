package com.example.habitcheckcalendar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private RecyclerView recyclerView;
    private HabitAdapter habitAdapter;
    private List<Habit> habitList = new ArrayList<>();
    private Button buttonAddHabit;
    private String selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        recyclerView = findViewById(R.id.recyclerView);
        buttonAddHabit = findViewById(R.id.button_add_habit);
        // Tải danh sách thói quen từ SharedPreferences
        loadHabitList();
        // Setup RecyclerView
        habitAdapter = new HabitAdapter(habitList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(habitAdapter);

        // Sự kiện chọn ngày từ CalendarView
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                // Filter habits based on selected date (if needed)
            }
        });
        // Thêm thói quen mới khi nhấn nút
        buttonAddHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddHabitDialog();
            }
        });
    }

    private void showAddHabitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add New Habit");

        final EditText input = new EditText(this);
        input.setHint("Enter habit name");
        builder.setView(input);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String habitName = input.getText().toString();
                habitList.add(new Habit(habitName, selectedDate, false));
                habitAdapter.notifyDataSetChanged();

                // Lưu danh sách thói quen vào SharedPreferences
                saveHabitList();
            }
        });
        builder.setNegativeButton("Cancel", null);

        builder.show();
    }
    private void saveHabitList() {
        SharedPreferences sharedPreferences = getSharedPreferences("HabitPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Dùng Gson để chuyển đổi list thành JSON
        Gson gson;
        gson = new Gson();
        String json = gson.toJson(habitList);

        // Lưu JSON vào SharedPreferences
        editor.putString("habitList", json);
        editor.apply();  // Áp dụng thay đổi
    }
    private void loadHabitList() {
        SharedPreferences sharedPreferences = getSharedPreferences("HabitPrefs", MODE_PRIVATE);

        // Lấy JSON từ SharedPreferences
        Gson gson = new Gson();
        String json = sharedPreferences.getString("habitList", null);

        // Chuyển đổi JSON thành danh sách thói quen
        Type type = new TypeToken<List<Habit>>() {}.getType();
        habitList = gson.fromJson(json, type);

        // Nếu không có dữ liệu, khởi tạo danh sách mới
        if (habitList == null) {
            habitList = new ArrayList<>();
        }
    }




}
