package com.abdel.mijnproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.abdel.mijnproject.Activity.AddList;
import com.abdel.mijnproject.Activity.FavoritePage;
import com.abdel.mijnproject.Activity.LoginActivity;
import com.abdel.mijnproject.Activity.ProfilePage;
import com.abdel.mijnproject.Activity.SignupActivity;


public class Dashboard extends DrawerActivity {
    ImageView btn_add, btn_favorite, btn_profile, btn_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btn_profile=findViewById(R.id.btn_profile);
        btn_favorite=findViewById(R.id.btn_favorite);
        btn_menu=findViewById(R.id.btn_menu);
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, AddList.class);
                startActivity(intent);
            }
        });
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ProfilePage.class);
                startActivity(intent);
            }
        });
        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, FavoritePage.class);
                startActivity(intent);
            }
        });

    }
}