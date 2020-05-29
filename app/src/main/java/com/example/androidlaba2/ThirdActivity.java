package com.example.androidlaba2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //searching calendar and button
        CalendarView calendarView = findViewById(R.id.calendar);
        Button button = findViewById(R.id.confirm);

        // string for chosen date
        final String[] chosenDate = new String[1];

        // listener that transforms chosen date to day-month-year format
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                chosenDate[0] = String.valueOf(dayOfMonth) + ":" + String.valueOf(month) + ":" + String.valueOf(year);
            }
        });

        button.setOnClickListener(v -> {
            // create empty intent
            Intent intent = new Intent();
            // adding data to intent
            intent.putExtra("result", chosenDate[0]);

            // choose result
            setResult(RESULT_OK, intent);

            // close Activity
            finish();
        });
    }

    // method when user press back button
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }
}
