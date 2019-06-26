package com.xhe.toasty;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.xhe.toasty.interfaces.ToastInterface;

/**
 * Created by gengqiquan on 2018/3/9.
 */

public class ToastDialog extends Dialog {
    private ToastDialog(@NonNull Context context) {
        super(context);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (Toasty.animationsRes > 0) {
            getWindow().setWindowAnimations(Toasty.animationsRes);
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);

    }

    public ToastInterface getToastView() {
        return toastView;
    }

    private void setToastView(ToastInterface toastView) {
        this.toastView = toastView;
    }

    ToastInterface toastView;


    public static ToastDialog createDialog(ToastInterface toastView) {
        ToastDialog toastDialog = new ToastDialog(toastView.getRealView().getContext());
        toastDialog.setContentView(toastView.getRealView());
        toastDialog.setToastView(toastView);
        return toastDialog;

    }

}
