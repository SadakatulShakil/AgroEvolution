package com.example.agroevolution.Activity.WholeSeller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.agroevolution.R;

public class WholeSellerActivity extends AppCompatActivity {
    private Toolbar dToolbar;
    private FrameLayout wholeSellerUiFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_seller);
        init();

        dToolbar.setTitle(getString(R.string.wholeSeller));
        dToolbar.setNavigationIcon(R.drawable.ic_arrow);

        dToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dToolbar = findViewById(R.id.toolbar);
            wholeSellerUiFrame = findViewById(R.id.frameForWholeSellerUI);
        }
    }
}