package com.onurciner.toastox;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Onur.Ciner on 21.12.2016.
 */

public class ToastOX {

    private static LayoutInflater mInflater;
    private static Toast mToast;
    private static View mView;

    public static void ok(Context context, String msg) {
        ok(context, msg, Toast.LENGTH_SHORT);
    }

    public static void ok(Context context, String msg, int duration) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_ok, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.show();
    }

    public static void ok(Context context, String msg, int duration,int gravity, int xOffset, int yOffset) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_ok, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.setGravity(gravity, xOffset, yOffset);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void ok(Context context, String msg,
                          Integer drawable) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_ok_icon, null);
        initSetButtonMsg(msg);
        ImageView img = (ImageView) mView.findViewById(R.id.img);
        img.setImageResource(drawable);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public static void ok(Context context, String msg, Integer drawable, int time) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_ok_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_ok, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
        if (time != 0) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mToast.cancel();
                }
            }, time);
        }
    }

    public static void error(Context context, String msg) {
        error(context, msg, Toast.LENGTH_SHORT);
    }


    public static void error(Context context, String msg, int duration) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_error, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.show();
    }
    public static void error(Context context, String msg, int duration, int gravity, int xOffset, int yOffset) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_error, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.setGravity(gravity,xOffset,yOffset);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void error(Context context, String msg, Integer drawable) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_error_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_error, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void error(Context context, String msg, Integer drawable, int time) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_error_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_error, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
        if (time != 0) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mToast.cancel();
                }
            }, time);
        }
    }

    public static void info(Context context, String msg) {
        info(context, msg, Toast.LENGTH_SHORT);
    }

    public static void info(Context context, String msg, int duration) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_info, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.show();
    }
    public static void info(Context context, String msg, int duration, int gravity, int xOffset, int yOffset ) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_info, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.setGravity(gravity, xOffset, yOffset);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void info(Context context, String msg, Integer drawable) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_info_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_info, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void info(Context context, String msg, Integer drawable, int time) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_info_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_info, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
        if (time != 0) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mToast.cancel();
                }
            }, time);
        }
    }

    public static void muted(Context context, String msg) {
        muted(context, msg, Toast.LENGTH_SHORT);
    }

    public static void muted(Context context, String msg, int duration) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_muted, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void muted(Context context, String msg, Integer drawable) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_muted_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_muted, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void muted(Context context, String msg, Integer drawable, int time) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_muted_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_muted, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
        if (time != 0) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mToast.cancel();
                }
            }, time);
        }
    }

    public static void warning(Context context, String msg) {
        warning(context, msg, Toast.LENGTH_SHORT);
    }

    public static void warning(Context context, String msg, int duration) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_warning, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.show();
    }
    public static void warning(Context context, String msg, int duration, int gravity, int xOffset, int yOffset) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_warning, null);
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.setGravity(gravity, xOffset, yOffset);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void warning(Context context, String msg, Integer drawable) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_warning_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_warning, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void warning(Context context, String msg, Integer drawable, int time) {
        mInflater = LayoutInflater.from(context);
        if (!drawable.equals("")) {
            mView = mInflater.inflate(R.layout.toastox_warning_icon, null);
            ImageView img = (ImageView) mView.findViewById(R.id.img);
            img.setImageResource(drawable);
        } else {
            mView = mInflater.inflate(R.layout.toastox_warning, null);
        }
        initSetButtonMsg(msg);
        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
        if (time != 0) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mToast.cancel();
                }
            }, time);
        }
    }

    private static Button initSetButtonMsg(String msg) {
        Button mButton = (Button) mView.findViewById(R.id.button);
        mButton.setText(msg);
        return mButton;
    }

    public static void CancelCurrentToast() {
        if (mToast != null)
            mToast.cancel();
    }


    public static void Tnull(Context context, String msg) {
        Tnull(context, msg, Toast.LENGTH_SHORT, Color.LTGRAY, Color.BLACK, 16);
    }

    public static void Tnull(Context context, String msg, int time) {
        Tnull(context, msg, time, Color.LTGRAY, Color.BLACK, 16);
    }

    public static void Tnull(Context context, String msg, int duration, int backgroundColor, int textColor, int textSize) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_null, null);
        initSetButtonMsg(msg);
        ((LinearLayout) mView.findViewById(R.id.layout)).setBackgroundColor(backgroundColor);
        ((Button) mView.findViewById(R.id.button)).setTextColor(textColor);
        ((Button) mView.findViewById(R.id.button)).setTextSize(textSize);

        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.show();
    }


    public static void TnullPos(Context context, String msg, int duration, int gravity, int xOffset, int yOffset) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(R.layout.toastox_null, null);
        initSetButtonMsg(msg);

        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.setGravity(gravity,xOffset,yOffset);
        mToast.show();
    }

    /**
     * Direk toast üzerinde layout görüntüleyebilirsiniz. DİKKAT layout'un içerisinde mutlaka "button" id'li bir buton olmalı.
     *
     * @param context
     * @param msg
     * @param duration
     * @param layout   Layout'un içerisinde mutlaka "button" id'li bir buton olmalı. Yazı o butonun üzerine yazılacaktır.
     */
    public static void Tnull(Context context, String msg, int duration, int layout) {
        mInflater = LayoutInflater.from(context);
        mView = mInflater.inflate(layout, null);
        initSetButtonMsg(msg);

        mToast = new Toast(context);
        mToast.setView(mView);
        mToast.setDuration(duration);
        mToast.show();
    }

}
