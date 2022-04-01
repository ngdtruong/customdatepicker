package com.example.myapplicationtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplicationtest.databinding.LayoutDialogNoTitleBinding;

public abstract class BaseNoTitleDialog extends BaseDialogFragment {

    private LayoutDialogNoTitleBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = LayoutDialogNoTitleBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.baseTitleDialogContainer.addView(provideContent());
    }

    protected abstract View provideContent();

    @Override
    protected int provideYPercent() {
        return TITLE_DIALOG_PERCENT;
    }

}