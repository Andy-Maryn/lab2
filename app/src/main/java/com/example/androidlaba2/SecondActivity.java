package com.example.androidlaba2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // search checkboxes for menu items
        Button button = findViewById(R.id.confirm);

        CheckBox donut = findViewById(R.id.donut);
        CheckBox croissant = findViewById(R.id.croissant);
        CheckBox pancake = findViewById(R.id.pancake);
        CheckBox cake = findViewById(R.id.cake);
        CheckBox coffee = findViewById(R.id.coffee);

        // list for menu
        List<String> menu = new ArrayList<>();

        button.setOnClickListener(v -> {
            // getting chosen dishes from checkbox
            if (donut.isChecked()) {
                menu.add("Пончик");
            }

            if (croissant.isChecked()) {
                menu.add("Круассан");
            }

            if (pancake.isChecked()) {
                menu.add("Блинчики");
            }

            if (cake.isChecked()) {
                menu.add("Кекс");
            }

            if (coffee.isChecked()) {
                menu.add("Кофе");
            }

            if (menu.isEmpty()) {
                menu.add("Вы ничего не заказали :(");
            }

            // empty intent
            Intent intent = new Intent();
            // addind date to intent
            intent.putExtra("result", menuToString(menu));

            // getting result
            setResult(RESULT_OK, intent);

            // closing Activity
            finish();
        });
    }
    // method to put data from a list to a string
    private String menuToString(List list) {
        String menu = "";
        for (int i = 0; i < list.size(); i++) {
            menu = menu + " " + list.get(i);
        }
        return menu;
    }
    // method when user click back
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }
}
