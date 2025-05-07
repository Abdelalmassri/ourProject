package com.abdel.mijnproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.abdel.mijnproject.Dashboard;
import com.abdel.mijnproject.R;

public class FavoritePage extends Activity {
    ImageView btn_home, btn_favorite, btn_profile, btn_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_favorite);
        btn_profile = findViewById(R.id.btn_profile);
        btn_favorite = findViewById(R.id.btn_favorite);
        btn_menu = findViewById(R.id.btn_menu);
        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FavoritePage.this, Dashboard.class));
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FavoritePage.this, ProfilePage.class));
                // halloo
            }
        });
    }
}