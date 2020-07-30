package com.example.agroevolution.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.agroevolution.R;

public class LogInActivity extends AppCompatActivity {
    private TextView userTypeTV;
    private Toolbar dToolbar;
    private Button signUpBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initViews();

        /*Intent intent = getIntent();
        final String userType = intent.getStringExtra("userType");*/

        dToolbar.setTitle(getString(R.string.login));
        dToolbar.setNavigationIcon(R.drawable.ic_arrow);


       /* if(userType.equals("farmer")){
            userTypeTV.setText("Farmer");

        }else if(userType.equals("agent")){
            userTypeTV.setText("Agent");

        }else if(userType.equals("wholeSeller")){
            userTypeTV.setText("WholeSeller");
        }*/

        signUpBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                //intent.putExtra("userType", userType);
                startActivity(intent);
            }
        });
        dToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void initViews() {
        signUpBt = findViewById(R.id.signUpBTN);
        //userTypeTV = findViewById(R.id.tvUserType);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dToolbar = findViewById(R.id.toolbar);
        }
    }
}