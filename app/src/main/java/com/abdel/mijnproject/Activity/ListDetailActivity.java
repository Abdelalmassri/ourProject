package com.abdel.mijnproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdel.mijnproject.Dashboard;
import com.abdel.mijnproject.R;


public class ListDetailActivity extends Activity {

    ImageView btn_home, btn_profile, btn_favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);
        btn_home=findViewById(R.id.btn_home);
        btn_profile=findViewById(R.id.btn_profile);
        btn_favorite=findViewById(R.id.btn_favorite);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListDetailActivity.this, Dashboard.class));
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListDetailActivity.this, ProfilePage.class));
                finish();
            }
        });

        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListDetailActivity.this, FavoritePage.class));
                finish();
            }
        });




    }
}