package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText minEditText = findViewById(R.id.min);
        EditText maxEditText = findViewById(R.id.max);
        TextView resultTextView = findViewById(R.id.rs);
        Button generateButton = findViewById(R.id.button);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String minStr = minEditText.getText().toString();
                String maxStr = maxEditText.getText().toString();

                if (!minStr.isEmpty() && !maxStr.isEmpty()) {
                    int min = Integer.parseInt(minStr);
                    int max = Integer.parseInt(maxStr);

                    if (min <= max) {
                        Random random = new Random();
                        int randomNumber = random.nextInt((max - min) + 1) + min;
                        resultTextView.setText("Result: "+ randomNumber);
                    } else {
                        resultTextView.setText("Max must be greater than or equal to Min");
                    }
                } else {
                    resultTextView.setText("Please enter both Min and Max values");
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
