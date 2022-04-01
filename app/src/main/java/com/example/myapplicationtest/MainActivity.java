package com.example.myapplicationtest;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplicationtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btn.setOnClickListener(v -> {
            DatePickerCustom dialog = new DatePickerCustom();
            dialog.setTitle("This is title");
            dialog.setTitleColor(Color.WHITE);
            dialog.setBackgroundColorHeader(Color.BLUE);
            dialog.setDialogDismissListener(new DialogDismissListener() {
                @Override
                public void onDismiss() {

                }
            });
            dialog.setDialogDatePickerListener(new DialogDatePickerListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDatePicker(int year, int month, int day) {
                    binding.tv.setText("Year " + year + ", "+ "Month " + month +", " + "Day " + day);
                }
            });
            dialog.show(getSupportFragmentManager());
        });

    }
}