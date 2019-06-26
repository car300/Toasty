package com.xhe.toasty;

import android.content.Context;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;

import com.xhe.toasty.interfaces.ToastInterface;

/**
 * Created by gengqiquan on 2018/3/7.
 */

public class ToastView extends AppCompatTextView implements ToastInterface {
    public ToastView(Context context) {
        super(context);
    }

    @Override
    public void setMessage(CharSequence msg) {
        setText(msg);

    }

    @Override
    public View getRealView() {
        return this;
    }
}
