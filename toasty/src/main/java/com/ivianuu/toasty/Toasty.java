/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.toasty;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CheckResult;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Toasty
 */
public final class Toasty {

    @ColorInt
    private static int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
    @ColorInt
    private static int ERROR_COLOR = Color.parseColor("#D50000");
    @ColorInt
    private static int INFO_COLOR = Color.parseColor("#3F51B5");
    @ColorInt
    private static int SUCCESS_COLOR = Color.parseColor("#388E3C");
    @ColorInt
    private static int WARNING_COLOR = Color.parseColor("#FFA900");
    @ColorInt
    private static int NORMAL_COLOR = Color.parseColor("#353A3E");

    private static final Typeface LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL);
    private static Typeface currentTypeface = LOADED_TOAST_TYPEFACE;
    private static int textSize = 16; // in SP

    private static boolean tintIcon = true;

    @SuppressLint("StaticFieldLeak")
    static Context context;

    private static final Handler toastHandler = new Handler(Looper.getMainLooper());

    private Toasty() {
        // no instances
    }

    /**
     * Must be called before using this class
     */
    public static void init(@NonNull Context context) {
        Toasty.context = context;
    }

    // NORMAL
    public static void normal(@StringRes int messageRes) {
        normal(context.getString(messageRes));
    }

    public static void normal(@NonNull CharSequence message) {
        normal(message, Toast.LENGTH_SHORT, null, false);
    }

    public static void normal(@StringRes int messageRes, Drawable icon) {
        normal(context.getString(messageRes, icon));
    }

    public static void normal(@NonNull CharSequence message, Drawable icon) {
        normal(message, Toast.LENGTH_SHORT, icon, true);
    }

    public static void normal(@StringRes int messageRes, int duration) {
        normal(context.getString(messageRes), duration);
    }
    
    public static void normal(@NonNull CharSequence message, int duration) {
        normal(message, duration, null, false);
    }

    public static void normal(@StringRes int messageRes, int duration,
                              Drawable icon) {
        normal(context.getString(messageRes, duration, icon));
    }

    public static void normal(@NonNull CharSequence message, int duration,
                               Drawable icon) {
        normal(message, duration, icon, true);
    }

    public static void normal(@StringRes int messageRes, int duration,
                              Drawable icon, boolean withIcon) {
        normal(context.getString(messageRes, duration, icon, withIcon));
    }

    public static void normal(@NonNull CharSequence message, int duration,
                               Drawable icon, boolean withIcon) {
        custom(message, icon, NORMAL_COLOR, duration, withIcon, true);
    }

    // WARNING
    public static void warning(@StringRes int messageRes) {
        warning(context.getString(messageRes), Toast.LENGTH_SHORT, true);
    }

    public static void warning(@NonNull CharSequence message) {
        warning(message, Toast.LENGTH_SHORT, true);
    }

    public static void warning(@StringRes int messageRes, int duration) {
        warning(context.getString(messageRes), duration);
    }

    public static void warning(@NonNull CharSequence message, int duration) {
        warning(message, duration, true);
    }

    public static void warning(@StringRes int messageRes, int duration, boolean withIcon) {
        warning(context.getString(messageRes), duration, withIcon);
    }

    public static void warning(@NonNull CharSequence message, int duration, boolean withIcon) {
        custom(message, ToastyUtils.getDrawable(R.drawable.ic_error_outline_white_48dp),
                WARNING_COLOR, duration, withIcon, true);
    }

    // INFO
    public static void info(@StringRes int messageRes) {
        info(context.getString(messageRes));
    }

    public static void info(@NonNull CharSequence message) {
        info(message, Toast.LENGTH_SHORT, true);
    }

    public static void info(@StringRes int messageRes, int duration) {
        info(context.getString(messageRes), duration);
    }

    public static void info(@NonNull CharSequence message, int duration) {
        info(message, duration, true);
    }

    public static void info(@StringRes int messageRes, int duration, boolean withIcon) {
        info(context.getString(messageRes), duration, withIcon);
    }

    public static void info(@NonNull CharSequence message, int duration, boolean withIcon) {
        custom(message, ToastyUtils.getDrawable(R.drawable.ic_info_outline_white_48dp),
                INFO_COLOR, duration, withIcon, true);
    }

    // SUCCESS
    public static void success(@StringRes int messageRes) {
        success(context.getString(messageRes));
    }

    public static void success(@NonNull CharSequence message) {
        success(message, Toast.LENGTH_SHORT, true);
    }

    public static void success(@StringRes int messageRes, int duration) {
        success(context.getString(messageRes), duration);
    }
    
    public static void success(@NonNull CharSequence message, int duration) {
        success(message, duration, true);
    }

    public static void success(@StringRes int messageRes, int duration, boolean withIcon) {
        success(context.getString(messageRes), duration, withIcon);
    }

    public static void success(@NonNull CharSequence message, int duration, boolean withIcon) {
        custom(message, ToastyUtils.getDrawable(R.drawable.ic_check_white_48dp),
                SUCCESS_COLOR, duration, withIcon, true);
    }
    
    // ERROR
    public static void error(@StringRes int messageRes) {
        error(context.getString(messageRes));
    }

    public static void error(@NonNull CharSequence message) {
        error(message, Toast.LENGTH_SHORT, true);
    }

    public static void error(@StringRes int messageRes, int duration) {
        error(context.getString(messageRes), duration);
    }

    public static void error(@NonNull CharSequence message, int duration) {
        error(message, duration, true);
    }

    public static void error(@StringRes int messageRes, int duration, boolean withIcon) {
        error(context.getString(messageRes), duration, withIcon);
    }

    public static void error(@NonNull CharSequence message, int duration, boolean withIcon) {
        custom(message, ToastyUtils.getDrawable(R.drawable.ic_clear_white_48dp),
                ERROR_COLOR, duration, withIcon, true);
    }

    // CUSTOM
    public static void custom(@NonNull CharSequence message, Drawable icon,
                               int duration, boolean withIcon) {
        custom(message, icon, -1, duration, withIcon, false);
    }

    public static void custom(@NonNull CharSequence message, @DrawableRes int iconRes,
                               @ColorInt int tintColor, int duration,
                               boolean withIcon, boolean shouldTint) {
        custom(message, ToastyUtils.getDrawable(iconRes),
                tintColor, duration, withIcon, shouldTint);
    }

    public static void custom(@NonNull final CharSequence message, final Drawable icon,
                              @ColorInt final int tintColor, final int duration,
                              final boolean withIcon, final boolean shouldTint) {
        toastHandler.post(new Runnable() {
            @Override
            public void run() {
                final Toast currentToast = new Toast(context);

                @SuppressLint("InflateParams")
                final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                        .inflate(R.layout.toast_layout, null);
                final ImageView toastIcon = toastLayout.findViewById(R.id.toast_icon);
                final TextView toastTextView = toastLayout.findViewById(R.id.toast_text);

                Drawable drawableFrame;

                if (shouldTint) {
                    drawableFrame = ToastyUtils.tint9PatchDrawableFrame(tintColor);
                } else {
                    drawableFrame = ToastyUtils.getDrawable(R.drawable.toast_frame);
                }

                ToastyUtils.setBackground(toastLayout, drawableFrame);

                if (withIcon) {
                    Drawable tintedIcon = icon;
                    if (tintedIcon == null) {
                        throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
                    }

                    if (tintIcon) {
                        tintedIcon = ToastyUtils.tintIcon(icon, DEFAULT_TEXT_COLOR);
                    }

                    ToastyUtils.setBackground(toastIcon, tintedIcon);
                } else {
                    toastIcon.setVisibility(View.GONE);
                }

                toastTextView.setTextColor(DEFAULT_TEXT_COLOR);
                toastTextView.setText(message);
                toastTextView.setTypeface(currentTypeface);
                toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

                currentToast.setView(toastLayout);
                currentToast.setDuration(duration);
                currentToast.show();
            }
        });
    }

    public static class Config {
        @ColorInt
        private int DEFAULT_TEXT_COLOR = Toasty.DEFAULT_TEXT_COLOR;
        @ColorInt
        private int ERROR_COLOR = Toasty.ERROR_COLOR;
        @ColorInt
        private int INFO_COLOR = Toasty.INFO_COLOR;
        @ColorInt
        private int SUCCESS_COLOR = Toasty.SUCCESS_COLOR;
        @ColorInt
        private int WARNING_COLOR = Toasty.WARNING_COLOR;

        private Typeface typeface = Toasty.currentTypeface;
        private int textSize = Toasty.textSize;

        private boolean tintIcon = Toasty.tintIcon;

        private Config() {
            // avoiding instantiation
        }

        @CheckResult
        public static Config getInstance() {
            return new Config();
        }

        public static void reset() {
            Toasty.DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");
            Toasty.ERROR_COLOR = Color.parseColor("#D50000");
            Toasty.INFO_COLOR = Color.parseColor("#3F51B5");
            Toasty.SUCCESS_COLOR = Color.parseColor("#388E3C");
            Toasty.WARNING_COLOR = Color.parseColor("#FFA900");
            Toasty.currentTypeface = LOADED_TOAST_TYPEFACE;
            Toasty.textSize = 16;
            Toasty.tintIcon = true;
        }

        @CheckResult
        public Config setTextColor(@ColorInt int textColor) {
            DEFAULT_TEXT_COLOR = textColor;
            return this;
        }

        @CheckResult
        public Config setErrorColor(@ColorInt int errorColor) {
            ERROR_COLOR = errorColor;
            return this;
        }

        @CheckResult
        public Config setInfoColor(@ColorInt int infoColor) {
            INFO_COLOR = infoColor;
            return this;
        }

        @CheckResult
        public Config setSuccessColor(@ColorInt int successColor) {
            SUCCESS_COLOR = successColor;
            return this;
        }

        @CheckResult
        public Config setWarningColor(@ColorInt int warningColor) {
            WARNING_COLOR = warningColor;
            return this;
        }

        @CheckResult
        public Config setToastTypeface(@NonNull Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        @CheckResult
        public Config setTextSize(int sizeInSp) {
            this.textSize = sizeInSp;
            return this;
        }

        @CheckResult
        public Config tintIcon(boolean tintIcon) {
            this.tintIcon = tintIcon;
            return this;
        }

        public void apply() {
            Toasty.DEFAULT_TEXT_COLOR = DEFAULT_TEXT_COLOR;
            Toasty.ERROR_COLOR = ERROR_COLOR;
            Toasty.INFO_COLOR = INFO_COLOR;
            Toasty.SUCCESS_COLOR = SUCCESS_COLOR;
            Toasty.WARNING_COLOR = WARNING_COLOR;
            Toasty.currentTypeface = typeface;
            Toasty.textSize = textSize;
            Toasty.tintIcon = tintIcon;
        }
    }
}
