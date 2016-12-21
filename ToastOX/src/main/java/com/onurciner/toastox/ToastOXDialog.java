/**
 *
 * new ToastOXDialog.Build(this)
        .setTitle("Başlık")
        .setContent("Mesajınız")
        .show();
 *
 *
 */

package com.onurciner.toastox;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.onurciner.toastox.utils.UtilsLibrary;

/**
 * Created by Onur.Ciner on 21.12.2016.
 */

public class ToastOXDialog {

    protected final Build mBuild;

    public final Build getBuild() {
        return mBuild;
    }

    protected ToastOXDialog(Build build) {
        mBuild = build;
        mBuild.bottomDialog = initBottomDialog(build);
    }

    @UiThread
    public void show() {
        if (mBuild != null && mBuild.bottomDialog != null)
            mBuild.bottomDialog.show();
    }

    @UiThread
    public void dismiss() {
        if (mBuild != null && mBuild.bottomDialog != null)
            mBuild.bottomDialog.dismiss();
    }

    @UiThread
    private Dialog initBottomDialog(final Build build) {
        final Dialog bottomDialog = new Dialog(build.context, R.style.BottomDialogs);
        View view = LayoutInflater.from(build.context).inflate(R.layout.toastox_dialog, null);

        ImageView vIcon = (ImageView) view.findViewById(R.id.bottomDialog_icon);
        TextView vTitle = (TextView) view.findViewById(R.id.bottomDialog_title);
        TextView vContent = (TextView) view.findViewById(R.id.bottomDialog_content);
        FrameLayout vCustomView = (FrameLayout) view.findViewById(R.id.bottomDialog_custom_view);
        Button vNegative = (Button) view.findViewById(R.id.bottomDialog_cancel);
        Button vPositive = (Button) view.findViewById(R.id.bottomDialog_ok);

        if (build.icon != null) {
            vIcon.setVisibility(View.VISIBLE);
            vIcon.setImageDrawable(build.icon);
        }

        if (build.title != null) {
            vTitle.setText(build.title);
        }

        if (build.content != null) {
            vContent.setText(build.content);
        }

        if (build.customView != null) {
            if (build.customView.getParent() != null)
                ((ViewGroup) build.customView.getParent()).removeAllViews();
            vCustomView.addView(build.customView);
            vCustomView.setPadding(build.customViewPaddingLeft, build.customViewPaddingTop, build.customViewPaddingRight, build.customViewPaddingBottom);
        }

        if (build.btn_positive != null) {
            vPositive.setVisibility(View.VISIBLE);
            vPositive.setText(build.btn_positive);
            vPositive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (build.btn_positive_callback != null)
                        build.btn_positive_callback.onClick(ToastOXDialog.this);
                    if (build.isAutoDismiss)
                        bottomDialog.dismiss();
                }
            });

            if (build.btn_colorPositive != 0) {
                vPositive.setTextColor(build.btn_colorPositive);
            }

            if (build.btn_colorPositiveBackground == 0) {
                TypedValue v = new TypedValue();
                boolean hasColorPrimary = build.context.getTheme().resolveAttribute(R.attr.colorPrimary, v, true);
                build.btn_colorPositiveBackground = !hasColorPrimary ? v.data : ContextCompat.getColor(build.context, R.color.colorPrimary);
            }

            Drawable buttonBackground = UtilsLibrary.createButtonBackgroundDrawable(build.context, build.btn_colorPositiveBackground);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                vPositive.setBackground(buttonBackground);
            } else {
                // noinspection deprecation
                vPositive.setBackgroundDrawable(buttonBackground);
            }
        }

        if (build.btn_negative != null) {
            vNegative.setVisibility(View.VISIBLE);
            vNegative.setText(build.btn_negative);
            vNegative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (build.btn_negative_callback != null)
                        build.btn_negative_callback.onClick(ToastOXDialog.this);
                    if (build.isAutoDismiss)
                        bottomDialog.dismiss();
                }
            });

            if (build.btn_colorNegative != 0) {
                vNegative.setTextColor(build.btn_colorNegative);
            }

            if (build.btn_colorNegativeBackground == 0) {
                TypedValue v = new TypedValue();
                boolean hasColorPrimary = build.context.getTheme().resolveAttribute(R.attr.colorPrimary, v, true);
                build.btn_colorNegativeBackground = !hasColorPrimary ? v.data : ContextCompat.getColor(build.context, R.color.colorPrimary);
            }

            Drawable buttonBackground = UtilsLibrary.createButtonBackgroundDrawable(build.context, build.btn_colorNegativeBackground);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                vNegative.setBackground(buttonBackground);
            } else {
                // noinspection deprecation
                vNegative.setBackgroundDrawable(buttonBackground);
            }
        }

        bottomDialog.setContentView(view);
        bottomDialog.setCancelable(build.isCancelable);
        bottomDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);

        return bottomDialog;
    }

    public static class Build {
        protected Context context;

        // Bottom Dialog
        protected Dialog bottomDialog;

        // Icon, Title and Content
        protected Drawable icon;
        protected CharSequence title, content;

        // Buttons
        protected CharSequence btn_negative, btn_positive;
        protected ButtonCallback btn_negative_callback, btn_positive_callback;
        protected boolean isAutoDismiss;

        // Button text colors
        protected int btn_colorNegative, btn_colorPositive;

        // Button background colors
        protected int btn_colorPositiveBackground;

        protected int btn_colorNegativeBackground;

        // Custom View
        protected View customView;
        protected int customViewPaddingLeft, customViewPaddingTop, customViewPaddingRight, customViewPaddingBottom;

        // Other options
        protected boolean isCancelable;

        public Build(@NonNull Context context) {
            this.context = context;
            this.isCancelable = true;
            this.isAutoDismiss = true;
        }

        public Build setTitle(@StringRes int titleRes) {
            setTitle(this.context.getString(titleRes));
            return this;
        }

        public Build setTitle(@NonNull CharSequence title) {
            this.title = title;
            return this;
        }

        public Build setContent(@StringRes int contentRes) {
            setContent(this.context.getString(contentRes));
            return this;
        }

        public Build setContent(@NonNull CharSequence content) {
            this.content = content;
            return this;
        }

        public Build setIcon(@NonNull Drawable icon) {
            this.icon = icon;
            return this;
        }

        public Build setIcon(@DrawableRes int iconRes) {
            this.icon = ResourcesCompat.getDrawable(context.getResources(), iconRes, null);
            return this;
        }

        public Build setPositiveBackgroundColorResource(@ColorRes int buttonColorRes) {
            this.btn_colorPositiveBackground = ResourcesCompat.getColor(context.getResources(), buttonColorRes, null);
            return this;
        }

        public Build setPositiveBackgroundColor(int color) {
            this.btn_colorPositiveBackground = color;
            return this;
        }

        public Build setPositiveTextColorResource(@ColorRes int textColorRes) {
            this.btn_colorPositive = ResourcesCompat.getColor(context.getResources(), textColorRes, null);
            return this;
        }

        public Build setPositiveTextColor(int color) {
            this.btn_colorPositive = color;
            return this;
        }

        public Build setPositiveText(@StringRes int buttonTextRes) {
            setPositiveText(this.context.getString(buttonTextRes));
            return this;
        }

        public Build setPositiveText(@NonNull CharSequence buttonText) {
            this.btn_positive = buttonText;
            return this;
        }

        public Build onPositive(@NonNull ButtonCallback buttonCallback) {
            this.btn_positive_callback = buttonCallback;
            return this;
        }

        public Build setNegativeBackgroundColorResource(@ColorRes int buttonColorRes) {
            this.btn_colorNegativeBackground = ResourcesCompat.getColor(context.getResources(), buttonColorRes, null);
            return this;
        }

        public Build setNegativeBackgroundColor(int color) {
            this.btn_colorNegativeBackground = color;
            return this;
        }

        public Build setNegativeTextColorResource(@ColorRes int textColorRes) {
            this.btn_colorNegative = ResourcesCompat.getColor(context.getResources(), textColorRes, null);
            return this;
        }

        public Build setNegativeTextColor(int color) {
            this.btn_colorNegative = color;
            return this;
        }

        public Build setNegativeText(@StringRes int buttonTextRes) {
            setNegativeText(this.context.getString(buttonTextRes));
            return this;
        }

        public Build setNegativeText(@NonNull CharSequence buttonText) {
            this.btn_negative = buttonText;
            return this;
        }

        public Build onNegative(@NonNull ButtonCallback buttonCallback) {
            this.btn_negative_callback = buttonCallback;
            return this;
        }

        public Build setCancelable(boolean cancelable) {
            this.isCancelable = cancelable;
            return this;
        }

        public Build autoDismiss(boolean autodismiss) {
            this.isAutoDismiss = autodismiss;
            return this;
        }

        public Build setCustomView(View customView) {
            this.customView = customView;
            this.customViewPaddingLeft = 0;
            this.customViewPaddingRight = 0;
            this.customViewPaddingTop = 0;
            this.customViewPaddingBottom = 0;
            return this;
        }

        public Build setCustomView(View customView, int left, int top, int right, int bottom) {
            this.customView = customView;
            this.customViewPaddingLeft = UtilsLibrary.dpToPixels(context, left);
            this.customViewPaddingRight = UtilsLibrary.dpToPixels(context, right);
            this.customViewPaddingTop = UtilsLibrary.dpToPixels(context, top);
            this.customViewPaddingBottom = UtilsLibrary.dpToPixels(context, bottom);
            return this;
        }

        @UiThread
        public ToastOXDialog build() {
            return new ToastOXDialog(this);
        }

        @UiThread
        public ToastOXDialog show() {
            ToastOXDialog bottomDialog = build();
            bottomDialog.show();
            return bottomDialog;
        }

    }

    public interface ButtonCallback {

        void onClick(@NonNull ToastOXDialog dialog);
    }


}
