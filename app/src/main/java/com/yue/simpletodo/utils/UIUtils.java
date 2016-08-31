package com.yue.simpletodo.utils;


import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.widget.TextView;

public class UIUtils {

    public static void setTextViewStrikeThrough(@NonNull TextView textView, boolean strikeThrough) {
        if (strikeThrough) {
            // strike through effect on the text
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            // no strike through effect
            textView.setPaintFlags(textView.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
