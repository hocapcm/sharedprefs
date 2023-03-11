package com.example.sharepre;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnBlack,btnRed,btnBlue,btnGreen;
    // Current count.
    private int count = 0;
    // Current background color.
    private int color;
    // Text view to display both count and color.
    private TextView tvShow;

    // Key for current count
    private final String COUNT_KEY = "count";
    // Key for current color
    private final String COLOR_KEY = "color";
    // Shared preferences object
    private SharedPreferences mPreferences;
    // Name of shared preferences file
    private static final String mSharedPrefFile = "sharedprefs1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views, color
        tvShow = (TextView) findViewById(R.id.tvShow);
        btnBlack = (Button) findViewById(R.id.btnBlack);
        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnRed = (Button) findViewById(R.id.btnRed);
        btnGreen = (Button) findViewById(R.id.btnGreen);

        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color1 = getResources().getColor(R.color.black);
                Toast.makeText(MainActivity.this, btnBlack.getText(), Toast.LENGTH_SHORT).show();
                tvShow.setBackgroundColor(color1);
                color = color1;
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color1 = getResources().getColor(R.color.blue);
                Toast.makeText(MainActivity.this, btnBlue.getText(), Toast.LENGTH_SHORT).show();
                tvShow.setBackgroundColor(color1);
                color = color1;
            }
        });

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color1 = getResources().getColor(R.color.red);
                Toast.makeText(MainActivity.this, btnRed.getText(), Toast.LENGTH_SHORT).show();
                tvShow.setBackgroundColor(color1);
                color = color1;
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color1 = getResources().getColor(R.color.green);
                Toast.makeText(MainActivity.this, btnGreen.getText(), Toast.LENGTH_SHORT).show();
                tvShow.setBackgroundColor(color1);
                color = color1;
            }
        });


        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        count = mPreferences.getInt(COUNT_KEY, 0);
        tvShow.setText(String.format("%s", count));
        color = mPreferences.getInt(COLOR_KEY, color);
        tvShow.setBackgroundColor(color);




    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putInt(COUNT_KEY, count);
        preferencesEditor.putInt(COLOR_KEY, color);
        preferencesEditor.apply();
    }




    public void countUp(View view) {
        count++;
        tvShow.setText(String.format("%s", count));
    }








}