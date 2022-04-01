package com.example.myapplicationtest;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplicationtest.databinding.LayoutDatePickerCustomBinding;

public class DatePickerCustom extends BaseNoTitleDialog{

    private LayoutDatePickerCustomBinding binding;

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
        binding.tvHeader.setText("adasdsd");
        binding.viewHeader.setBackgroundColor(Color.GREEN);
    }

}
