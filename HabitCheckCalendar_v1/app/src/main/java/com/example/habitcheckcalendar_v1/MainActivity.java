package com.example.habitcheckcalendar_v1;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 8); // 1 cột cho tên thói quen, 7 cột cho các ngày
        recyclerView.setLayoutManager(gridLayoutManager);
        HabitAdapter adapter = new HabitAdapter(habitList); // habitList chứa danh sách thói quen
        recyclerView.setAdapter(adapter);

    }
    private void saveHabitList() {
        SharedPreferences sharedPreferences = getSharedPreferences("HabitPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(habitList);
        editor.putString("habitList", json);
        editor.apply();
    }

    private void loadHabitList() {
        SharedPreferences sharedPreferences = getSharedPreferences("HabitPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("habitList", null);
        Type type = new TypeToken<List<Habit>>() {}.getType();
        habitList = gson.fromJson(json, type);

        if (habitList == null) {
            habitList = new ArrayList<>();
        }
    }

}