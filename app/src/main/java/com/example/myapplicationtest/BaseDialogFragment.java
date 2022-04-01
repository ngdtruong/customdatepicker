package com.example.myapplicationtest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BaseDialogFragment extends DialogFragment {

    protected final int COMMON_PERCENT = 28;
    protected final int CENTER_PERCENT = 50;
    protected final int TITLE_DIALOG_PERCENT = 15;

    protected DialogDismissListener dialogDismissListener;

    public void setDialogDismissListener(DialogDismissListener dialogDismissListener) {
        if (this.dialogDismissListener != null) {
            this.dialogDismissListener = null;
        }
        this.dialogDismissListener = dialogDismissListener;
    }

    private final String TAG = this.getClass().getName();

    public void show(FragmentManager fragmentManager) {
        show(fragmentManager, TAG);
    }

    @Override
    public void show(@NonNull FragmentManager manager, @Nullable String tag) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(this, TAG);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, AndroidUtil.isTablet(requireContext()) ? R.style.BaseDialogTablet : R.style.BaseDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (getDialog() != null) {
            if (getDialog().getWindow() != null) {
                WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();

                int screenHeight = AndroidUtil.getScreenHeight();
                float mY = (float) (screenHeight / 100) * provideYPercent();
                params.y = (int) mY;
                params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;

                getDialog().getWindow().setAttributes(params);
                getDialog().getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            }
        }


        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        setupDialogWindow();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        if(dialogDismissListener != null){
            dialogDismissListener.onDismiss();
        }
    }

    protected abstract int provideYPercent();

    private void setupDialogWindow() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.requestFeature(Window.FEATURE_NO_TITLE);
//                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                window.setLayout((int) (AndroidUtil.displaySize.x * 0.9),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            }
        }
    }
}
