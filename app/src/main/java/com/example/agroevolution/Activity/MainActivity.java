package com.example.agroevolution.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.agroevolution.R;

public class MainActivity extends AppCompatActivity {

    private TextView btFarmer, btWholeSeller, btAgent;
    private String clickType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickType = "farmer";
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                intent.putExtra("userType", clickType);
                startActivity(intent);
            }
        });

        btAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickType = "agent";
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                intent.putExtra("userType", clickType);
                startActivity(intent);
            }
        });

        btWholeSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickType = "wholeSeller";
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                intent.putExtra("userType", clickType);
                startActivity(intent);
            }
        });
    }

    private void init() {
        btAgent = findViewById(R.id.agent);
        btFarmer = findViewById(R.id.farmer);
        btWholeSeller = findViewById(R.id.wholeSeller);
    }
}
