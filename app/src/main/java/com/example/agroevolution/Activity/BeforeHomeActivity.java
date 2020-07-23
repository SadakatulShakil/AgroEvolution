package com.example.agroevolution.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.agroevolution.Activity.Agent.AgentActivity;
import com.example.agroevolution.Activity.Farmer.FarmerActivity;
import com.example.agroevolution.Activity.WholeSeller.WholeSellerActivity;
import com.example.agroevolution.R;

public class BeforeHomeActivity extends AppCompatActivity {

    private Button btVrifyNext, btfillProfileNext;
    private ConstraintLayout profileLayout,verifyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_home);

        init();

        final Intent intent = getIntent();
        final String userType = intent.getStringExtra("userType");

        btVrifyNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BeforeHomeActivity.this, "Number Verified", Toast.LENGTH_SHORT).show();
                profileLayout.setVisibility(View.VISIBLE);
                verifyLayout.setVisibility(View.GONE);

            }
        });

        btfillProfileNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userType.equals("farmer")){
                    Intent intent = new Intent(BeforeHomeActivity.this, FarmerActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(userType.equals("wholeSeller")){
                    Intent intent = new Intent(BeforeHomeActivity.this, WholeSellerActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(userType.equals("agent")){
                    Intent intent = new Intent(BeforeHomeActivity.this, AgentActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void init() {

        btVrifyNext = findViewById(R.id.verifyNext);
        btfillProfileNext = findViewById(R.id.nextBtn);
        profileLayout = findViewById(R.id.fillProfileLayout);
        verifyLayout = findViewById(R.id.verifypLayout);
    }
}