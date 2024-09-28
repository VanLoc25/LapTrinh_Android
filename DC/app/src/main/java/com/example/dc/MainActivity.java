package com.example.dc;

import android.os.Bundle;

import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity; // Add this line

import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private GridLayout gridCalendar;
    //private RecyclerView recyclerView; // Khai báo biến recyclerView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridCalendar = findViewById(R.id.gridCalendar);

        // Example: dynamically adding TextViews for each day
        for (int i = 1; i <= 30; i++) {
            TextView dayView = new TextView(this);
            dayView.setText(String.valueOf(i));
            dayView.setTextSize(18);
            dayView.setPadding(8, 8, 8, 8);
            dayView.setBackgroundResource(R.drawable.day_background); // Set background drawable
            dayView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle marking the day here
                    dayView.setBackgroundResource(R.drawable.day_selected_background);
                }
            });
            gridCalendar.addView(dayView);
        }

        // Handle additional logic like assigning work hours and displaying them
    }
}