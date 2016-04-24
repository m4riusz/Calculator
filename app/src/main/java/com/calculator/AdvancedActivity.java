package com.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.calculator.util.Calc;
import com.calculator.util.PostfixNotation;
import com.calculator.util.ReversePolishNotation;

public class AdvancedActivity extends AppCompatActivity {

    private Display display;
    private PostfixNotation reversePolishNotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
        display = new Display((TextView) findViewById(R.id.display));
        reversePolishNotation = new ReversePolishNotation();
    }

    public void equalsPressed(View view) {
        try {
            double result = reversePolishNotation.evaluate(reversePolishNotation.parse(display.getText()));
            display.setText(String.valueOf(result));
        } catch (IllegalArgumentException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Syntax error!", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonPressed(View view) {
        Button pressedButton = (Button) findViewById(view.getId());
        String text = pressedButton.getText().toString();
        if (Calc.OPERATORS_WITH_BRACKETS.contains(text)) {
            display.add(text + Calc.LEFT_BRACKET);
        } else if (!text.equals(Calc.DOT) || !display.getLastChar().equals(Calc.DOT)) {
            display.add(text);
        }
    }

    public void clearPressed(View view) {
        display.clear();
    }

    public void removeFromDisplay(View view) {
        String text = display.getText();
        int length = text.length();

        if (length >= 4 && Calc.OPERATORS_WITH_BRACKETS.contains(text.substring(length - 4, length - 1))) {
            display.setText(text.substring(0, length - 4));
        } else if (length >= 3 && Calc.OPERATORS_WITH_BRACKETS.contains(text.substring(length - 3, length - 1))) {
            display.setText(text.substring(0, length - 3));
        } else if (length > 0) {
            display.setText(text.substring(0, length - 1));
        }
    }

}
