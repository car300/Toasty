# Toasty
### 自定义toast
#### 功能：
* 1.设置显示时间
* 2.设置显示位置
* 3.直接替换当前显示中toast
* 4.自定义布局


#### 在build.gradle中导入
~~~
compile 'com.hexiang:toasty:1.0.2'
~~~
#### 使用：
~~~
Toasty.with(this)
                    .message("hello world")
                    .duration(Toasty.LENGTH_LONG) //持续时间
                    .gravity(Gravity.BOTTOM) //位置
                    .replace(true)//是否直接替换
                    .waiting(true)//按顺序显示，如设置replace=true则无效
                    .show()
~~~
#### 自定义布局：
~~~
   Toasty.setToastFactory(new ToastFactory() {
            @Override
            ToastInterface createToastView(Activity activity) {
                    ToastView toastView = new ToastView(activity);
                    toastView.setTextSize(13f);
                    toastView.setTextColor(Color.WHITE);
                    toastView.setGravity(Gravity.CENTER);
                    toastView.setShadowLayer(2.75f, 0, 0, 0xBB000000);
                    toastView.setPadding(dip(activity, 18f), dip(activity, 8f), dip(activity, 18f), dip(activity, 8f));

                    GradientDrawable bg = new GradientDrawable();
                    bg.setCornerRadius(dip(activity, 12));
                    bg.setColor(0x77000000);
                    toastView.setBackgroundDrawable(bg);

                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                    lp.setMargins(0, dip(activity, 50f), 0, dip(activity, 50f));
                    toastView.setLayoutParams(lp);
                    return toastView;
            }
        });
~~~
