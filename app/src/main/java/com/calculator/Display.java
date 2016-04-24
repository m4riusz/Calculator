package com.calculator;

import android.widget.TextView;

/**
 * Created by mariusz on 24.04.16.
 */
public class Display {
    public static final String SUFFIX = ".0";
    private TextView textView;

    public Display(TextView textView) {
        this.textView = textView;
    }

    public void add(String text) {
        textView.append(text);
    }

    public void clear() {
        textView.setText("");
    }

    public void setText(String text) {
        if (text.endsWith(SUFFIX)) {
            textView.setText(text.substring(0, text.length() - SUFFIX.length()));
        } else {
            textView.setText(text);
        }
    }

    public String getText() {
        return textView.getText().toString();
    }

    public int getTextLength() {
        return textView.getText().length();
    }

    public String getLastChar() {
        if (textView.getText().length() > 1) {
            return String.valueOf(textView.getText().charAt(textView.getText().length() - 1));
        }
        return "";
    }
}
