package com.xhe.toasty.interfaces;

import androidx.annotation.IntDef;

import com.xhe.toasty.Toasty;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by hexiang on 2018/2/28.
 */

@IntDef({Toasty.DISCARD, Toasty.REPLACE_NOW, Toasty.REPLACE_BEHIND})
@Retention(RetentionPolicy.SOURCE)
public @interface ToastReplaceType {
}
