package com.abdel.mijnproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.abdel.mijnproject.R;

public class ProfileActivity extends Activity {

    private TextView tvName, tvAge, tvEmail;
    private Button btnEdit, btnLogout, btnDelete;
    private ImageButton btnProfile, btnAdd, btnFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        // Koppel de elementen
        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvEmail = findViewById(R.id.tvEmail);

        btnEdit = findViewById(R.id.btnEdit);
        btnLogout = findViewById(R.id.btnLogout);
        btnDelete = findViewById(R.id.btnDelete);

        btnProfile = findViewById(R.id.btn_profile);
        btnAdd = findViewById(R.id.btn_add);
        btnFavorite = findViewById(R.id.btn_favorite);

        // Vul tijdelijke gegevens in

        tvName.setText("Mohamed");
        tvAge.setText("21");
        tvEmail.setText("mohamed@example.com");

        // Knopacties

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Edit profile clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Account deleted", Toast.LENGTH_SHORT).show();
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Already on Profile", Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Go to Add screen", Toast.LENGTH_SHORT).show();
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Go to Favorites", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
