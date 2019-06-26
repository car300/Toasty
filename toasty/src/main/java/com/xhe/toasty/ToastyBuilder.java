package com.xhe.toasty;

import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.xhe.toasty.interfaces.ToastDuration;
import com.xhe.toasty.interfaces.ToastGravity;
import com.xhe.toasty.interfaces.ToastReplaceType;

/**
 * Created by hexiang on 2018/2/6.
 */
final public class ToastyBuilder {
    private String activityName;//界面类
    private String msg;//展示的内容
    /**
     * 持续时间
     *
     * @see com.xhe.toasty.Toasty#LENGTH_SHORT
     */
    private long duration = Toasty.LENGTH_SHORT;//持续时间

    private int gravity = Gravity.BOTTOM;//位置
    /**
     * 显示中再次请求替换方式
     *
     * @see com.xhe.toasty.Toasty#DISCARD
     */
    private int replaceType = Toasty.DISCARD;

    ToastHandler toastHandler;
    private Toast nativeToast = null;

    protected void setNativeToast(Toast nativeToast) {
        this.nativeToast = nativeToast;
    }

    protected ToastyBuilder(String activityName) {
        this.activityName = activityName;
    }

    public void setToastHandler(ToastHandler toastHandler) {
        this.toastHandler = toastHandler;
    }

    /**
     * 持续时间
     *
     * @param duration
     * @return
     */
    public ToastyBuilder duration(@ToastDuration int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * 文本内容
     *
     * @param msg
     * @return
     */
    public ToastyBuilder message(@NonNull String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 位置
     * 只能上中下
     *
     * @param gravity
     * @return
     */
    public ToastyBuilder gravity(@ToastGravity int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * 显示中再次请求替换方式
     *
     * @param replaceType
     * @see com.xhe.toasty.Toasty#DISCARD
     */
    public ToastyBuilder replaceType(@ToastReplaceType int replaceType) {
        this.replaceType = replaceType;
        return this;
    }

    protected String getMsg() {
        return msg;
    }

    protected long getDuration() {
        return duration;
    }

    protected int getGravity() {
        return gravity;
    }

    protected int getReplaceType() {
        return replaceType;
    }

    protected String getActivityName() {
        return activityName;
    }


    public void show() {
        if (nativeToast == null) {
            toastHandler.show(this);
            return;
        }
        nativeToast.setText(this.msg);
        nativeToast.setGravity(gravity, 0, Toasty.dip(nativeToast.getView().getContext(), Toasty.offsetYDip));
        if (duration == Toasty.LENGTH_LONG) {
            nativeToast.setDuration(Toast.LENGTH_LONG);
        }
        nativeToast.show();
    }

}
