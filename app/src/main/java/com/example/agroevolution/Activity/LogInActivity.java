package com.example.agroevolution.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.agroevolution.Fragment.AgentLogInFragment;
import com.example.agroevolution.Fragment.FarmerLogInFragment;
import com.example.agroevolution.Fragment.WholeSellerLogInFragment;
import com.example.agroevolution.R;

public class LogInActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private Toolbar dToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initViews();

        Intent intent = getIntent();
        String userType = intent.getStringExtra("userType");

        dToolbar.setTitle(getString(R.string.login));
        dToolbar.setNavigationIcon(R.drawable.ic_arrow);

        if(userType.equals("farmer")){

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameForLogInType,new FarmerLogInFragment())
                    .commit();
        }else if(userType.equals("agent")){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameForLogInType,new AgentLogInFragment())
                    .commit();
        }else if(userType.equals("wholeSeller")){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameForLogInType,new WholeSellerLogInFragment())
                    .commit();
        }

        dToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void initViews() {
        frameLayout = findViewById(R.id.frameForLogInType);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dToolbar = findViewById(R.id.toolbar);
        }
    }
}