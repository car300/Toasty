package com.xhe.toasty.interfaces;

import android.view.Gravity;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by hexiang on 2018/2/28.
 */

@IntDef({Gravity.TOP, Gravity.CENTER, Gravity.BOTTOM})
@Retention(RetentionPolicy.SOURCE)
public @interface ToastGravity {
}
