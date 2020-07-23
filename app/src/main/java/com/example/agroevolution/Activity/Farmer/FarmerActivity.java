package com.example.agroevolution.Activity.Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.agroevolution.R;

public class FarmerActivity extends AppCompatActivity {
    private Toolbar dToolbar;
    private RadioGroup uploadTypeGroup, presentProductGroup;
    private TextView futureDemo, presentDemo;
    private ConstraintLayout futureLayout, fixedLayout, auctionLayout;
    private static final String TAG = "FarmerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);

        init();

        initView();

        dToolbar.setTitle(getString(R.string.farmer));
        dToolbar.setNavigationIcon(R.drawable.ic_arrow);

        dToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        RadioButton rbType1 = (RadioButton) uploadTypeGroup.findViewById(uploadTypeGroup.getCheckedRadioButtonId());
        String uploadType = (String) rbType1.getText();

        Log.d(TAG, "onCreate: " +uploadType);

        RadioButton rbType2 = (RadioButton) presentProductGroup.findViewById(presentProductGroup.getCheckedRadioButtonId());
        String presentProductType = (String) rbType2.getText();
        Log.d(TAG, "onCreate: " +presentProductType);


        if(uploadType.equals("Future")){
            futureDemo.setVisibility(View.VISIBLE);
            futureLayout.setVisibility(View.VISIBLE);
            presentDemo.setVisibility(View.GONE);
            presentProductGroup.setVisibility(View.GONE);
            auctionLayout.setVisibility(View.GONE);
            fixedLayout.setVisibility(View.GONE);
            auctionLayout.setVisibility(View.GONE);
        }
       /* else if(uploadType.equals("Present")){
            futureDemo.setVisibility(View.GONE);
            futureLayout.setVisibility(View.GONE);
            presentDemo.setVisibility(View.VISIBLE);
            presentProductGroup.setVisibility(View.VISIBLE);
        }

        if(presentProductType.equals("Fixed")){
            fixedLayout.setVisibility(View.VISIBLE);
            auctionLayout.setVisibility(View.GONE);
        }
        else if(presentProductType.equals("Auction")){
            fixedLayout.setVisibility(View.GONE);
            auctionLayout.setVisibility(View.VISIBLE);
        }*/


    }

    private void initView() {

    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dToolbar = findViewById(R.id.toolbar);
        }

        uploadTypeGroup = findViewById(R.id.typeOfUpload);
        presentProductGroup = findViewById(R.id.typeOfPresentProduct);

        futureDemo = findViewById(R.id.demoFutureProduct);
        presentDemo = findViewById(R.id.demoPresentProductType);

        futureLayout = findViewById(R.id.futureProductLayout);
        fixedLayout = findViewById(R.id.fixedProductLayout);
        auctionLayout = findViewById(R.id.auctionProductLayout);
    }
}