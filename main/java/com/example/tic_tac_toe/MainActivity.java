package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0; // 0 = X, 1 = O
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void Check(View view) {
        Button btnCurrent = (Button) view;

        // Check if the button is empty before allowing any change
        if (btnCurrent.getText().toString().equals("")) {
            count++;

            // Set the text for the current button based on the player
            if (flag == 0) {
                btnCurrent.setText("X");
                flag = 1; // Switch to O
            } else {
                btnCurrent.setText("O");
                flag = 0; // Switch to X
            }

            // Change the button's background color to blue
            btnCurrent.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

            // Avoid accessing null button texts after the first click
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();
        }

        // Check win conditions
        if (b1.equals(b2) && b2.equals(b3) && !b1.isEmpty()) {
            Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
            resetGame();
        }
        if (b4.equals(b5) && b5.equals(b6) && !b4.isEmpty()) {
            Toast.makeText(this, "Winner is " + b4, Toast.LENGTH_SHORT).show();
            resetGame();
        }
        if (b7.equals(b8) && b8.equals(b9) && !b7.isEmpty()) {
            Toast.makeText(this, "Winner is " + b7, Toast.LENGTH_SHORT).show();
            resetGame();
        }
        if (b1.equals(b4) && b4.equals(b7) && !b1.isEmpty()) {
            Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
            resetGame();
        }
        if (b2.equals(b5) && b5.equals(b8) && !b2.isEmpty()) {
            Toast.makeText(this, "Winner is " + b2, Toast.LENGTH_SHORT).show();
            resetGame();
        }
        if (b3.equals(b6) && b6.equals(b9) && !b3.isEmpty()) {
            Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
            resetGame();
        }

        // Check diagonals
        if (b1.equals(b5) && b5.equals(b9) && !b1.isEmpty()) {
            Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
            resetGame();
        }
        if (b3.equals(b5) && b5.equals(b7) && !b3.isEmpty()) {
            Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
            resetGame();
        }

        // Check for draw
        if (count == 9) {
            Toast.makeText(this, "It's a Draw!", Toast.LENGTH_SHORT).show();
            resetGame();
        }
    }

    private void resetGame() {
        // Reset all buttons
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        // Reset background color to default (optional, can set to white)
        btn1.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        btn2.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        btn3.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        btn4.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        btn5.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        btn6.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        btn7.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        btn8.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        btn9.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));

        // Reset game state
        count = 0;
        flag = 0;
    }
}
