package com.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.calculator.util.ReversePolishNotation;

/**
 * Created by mariusz on 12.03.16.
 */
public class SimpleActivity extends AppCompatActivity {

    private TextView display;
    private ReversePolishNotation reversePolishNotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        display = (TextView) findViewById(R.id.display);
        reversePolishNotation = new ReversePolishNotation();
    }

    public void equalsPressed(View view) {
        try {
            double result = reversePolishNotation.evaluate(reversePolishNotation.parse(readDisplayText()));
            display.setText(String.valueOf(result));
        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Syntax error!", Toast.LENGTH_SHORT).show();
        }
    }

    public void digitPressed(View view) {
        Button pressedNumber = (Button) findViewById(view.getId());
        addToDisplay(pressedNumber.getText().toString());
    }

    public void clearPressed(View view) {
        clearDisplay();
    }

    public void removeFromDisplay(View view) {
        if (readDisplayText().length() > 0) {
            display.setText(readDisplayText().substring(0, readDisplayText().length() - 1));
        }
    }

    private String readDisplayText() {
        return display.getText().toString();
    }

    private void clearDisplay() {
        display.setText("");
    }

    private void addToDisplay(String text) {
        display.setText(display.getText() + text);
    }


}

