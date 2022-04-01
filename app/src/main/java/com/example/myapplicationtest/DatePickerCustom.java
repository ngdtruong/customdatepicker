package com.example.myapplicationtest;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplicationtest.databinding.LayoutDatePickerCustomBinding;

public class DatePickerCustom extends BaseNoTitleDialog{

    private LayoutDatePickerCustomBinding binding;
    private String title;
    private int color, colorBackground, year, month, day;
    private DialogDatePickerListener dialogDatePickerListener;

    public void setTitle(String title){
        this.title = title;
    }

    public void setTitleColor(int color) {
        this.color = color;
    }

    public void setBackgroundColorHeader(int colorBackground){
        this.colorBackground = colorBackground;
    }

    public void setDialogDatePickerListener(DialogDatePickerListener dialogDatePickerListener) {
        this.dialogDatePickerListener = dialogDatePickerListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View provideContent() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        binding = LayoutDatePickerCustomBinding.inflate(inflater);
        return binding.getRoot();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setCancelable(false);
        initControls();
        initEvents();
    }

    private void initEvents() {
        binding.btnOk.setOnClickListener(v -> {
            dialogDatePickerListener.onDatePicker(binding.dp.getYear(), binding.dp.getMonth() + 1, binding.dp.getDayOfMonth());
            dismiss();
        });

        binding.btnExit.setOnClickListener(v -> dismiss());
    }

    private void initControls() {
        binding.tvHeader.setText(title == null ? "Title" : title);
        binding.tvHeader.setTextColor(color);
        binding.viewHeader.setBackgroundColor(colorBackground);
    }

}
