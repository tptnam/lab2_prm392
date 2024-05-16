package com.example.lab2_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnSum, btnMinus, btnMultiply, btnDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize the EditText fields
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        // Initialize the Buttons
        btnSum = findViewById(R.id.btnsum);
        btnMinus = findViewById(R.id.btnminus);
        btnMultiply = findViewById(R.id.btnmultiply);
        btnDivision = findViewById(R.id.btndivision);

        // Set OnClickListener for Sum button
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.SUM);
            }
        });

        // Set OnClickListener for Minus button
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.MINUS);
            }
        });

        // Set OnClickListener for Multiply button
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.MULTIPLY);
            }
        });

        // Set OnClickListener for Division button
        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.DIVISION);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private enum Operation {
        SUM, MINUS, MULTIPLY, DIVISION
    }

    private void performOperation(Operation operation) {
        String strNum1 = num1.getText().toString();
        String strNum2 = num2.getText().toString();

        if (strNum1.isEmpty() || strNum2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double number1 = Double.parseDouble(strNum1);
        double number2 = Double.parseDouble(strNum2);
        double result = 0;

        switch (operation) {
            case SUM:
                result = number1 + number2;
                break;
            case MINUS:
                result = number1 - number2;
                break;
            case MULTIPLY:
                result = number1 * number2;
                break;
            case DIVISION:
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        Toast.makeText(this, "Result: " + result, Toast.LENGTH_SHORT).show();
    }


}
