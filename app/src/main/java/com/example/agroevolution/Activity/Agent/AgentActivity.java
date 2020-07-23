package com.example.agroevolution.Activity.Agent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.agroevolution.R;

public class AgentActivity extends AppCompatActivity {

    private Toolbar dToolbar;
    private FrameLayout agentUiFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent);

        init();

        dToolbar.setTitle(getString(R.string.agent));
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
            agentUiFrame = findViewById(R.id.frameForAgentUI);
        }
    }
}