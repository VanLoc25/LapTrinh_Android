package com.example.danhdaungaylam;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView weekRecyclerView = findViewById(R.id.weekRecyclerView);
        weekRecyclerView.setLayoutManager(new GridLayoutManager(this, 7)); // 7 cột cho 7 ngày

// Danh sách các thứ trong tuần
        List<String> weekDaysList = Arrays.asList("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");

// Danh sách các ngày trong tuần (ví dụ lấy từ lịch hiện tại)
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); // Bắt đầu từ Chủ Nhật
        List<String> daysList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            daysList.add(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

// Khởi tạo Adapter và gán cho RecyclerView
        WeekAdapter adapter = new WeekAdapter(weekDaysList, daysList);
        weekRecyclerView.setAdapter(adapter);

    }



}

