package com.example.test;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioGroup radGroup = findViewById(R.id.Rad_group);
        FrameLayout frameLayout = findViewById(R.id.frame_layout);

        radGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            if (selectedRadioButton != null) {
                String colorText = selectedRadioButton.getText().toString().trim().toLowerCase();

                switch (colorText) {
                    case "red":
                        frameLayout.setBackgroundColor(Color.RED);
                        break;
                    case "blue":
                        frameLayout.setBackgroundColor(Color.BLUE);
                        break;
                    case "green":
                        frameLayout.setBackgroundColor(Color.GREEN);
                        break;
                    default:
                        frameLayout.setBackgroundColor(Color.WHITE);
                        break;
                }
            }
        });
    }
}
