package com.example.agroevolution.Activity.Farmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agroevolution.R;

public class FarmerActivity extends AppCompatActivity {
    private Toolbar dToolbar;
    private RadioGroup uploadTypeGroup, presentProductGroup;
    private String uploadType;
    private View futureLayout, fixedLayout, auctionLayout;
    private ConstraintLayout presentTypeOfProduct;
    private static final String TAG = "FarmerActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);

        init();

        dToolbar.setTitle(getString(R.string.farmer));
       /* dToolbar.setNavigationIcon(R.drawable.ic_arrow);

        dToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
*/

        uploadTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbType1 = (RadioButton) uploadTypeGroup.findViewById(uploadTypeGroup.getCheckedRadioButtonId());
                uploadType = (String) rbType1.getText();

                Toast.makeText(FarmerActivity.this, uploadType+ " is Clicked!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onCreate: " +uploadType);

                if(uploadType.equals("Future")){
                    futureLayout.setVisibility(View.VISIBLE);
                    presentTypeOfProduct.setVisibility(View.GONE);
                    auctionLayout.setVisibility(View.GONE);
                    fixedLayout.setVisibility(View.GONE);

                }
                else if(uploadType.equals("Present")){
                    presentTypeOfProduct.setVisibility(View.VISIBLE);
                    futureLayout.setVisibility(View.GONE);
                }

            }
        });

        presentProductGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbType2 = (RadioButton) presentProductGroup.findViewById(presentProductGroup.getCheckedRadioButtonId());
                String presentProductType = (String) rbType2.getText();

                Toast.makeText(FarmerActivity.this, presentProductType+ " is Clicked!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onCreate: " +presentProductType);

                if(presentProductType.equals("Fixed")){
                    fixedLayout.setVisibility(View.VISIBLE);
                    auctionLayout.setVisibility(View.GONE);
                }

                else if(presentProductType.equals("Auction")){
                    fixedLayout.setVisibility(View.GONE);
                    auctionLayout.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dToolbar = findViewById(R.id.toolbar);
        }

        uploadTypeGroup = findViewById(R.id.typeOfUpload);
        presentProductGroup = findViewById(R.id.typeOfPresentProduct);
        presentTypeOfProduct = findViewById(R.id.presentProductOption);


        futureLayout = findViewById(R.id.uploadFutureProduct);
        fixedLayout = findViewById(R.id.uploadFixedProduct);
        auctionLayout = findViewById(R.id.uploadAuctionProduct);
    }
}