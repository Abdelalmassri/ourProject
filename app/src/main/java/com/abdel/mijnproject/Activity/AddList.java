package com.abdel.mijnproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.abdel.mijnproject.Dashboard;
import com.abdel.mijnproject.R;

public class AddList extends Activity {
    ImageView btn_home, btn_profile, btn_favorite;
    EditText txtListName;
    Button btnSaveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        // Initialize views
        btn_home = findViewById(R.id.btn_home);
        btn_profile = findViewById(R.id.btn_profile);
        btn_favorite = findViewById(R.id.btn_favorite);
        txtListName = findViewById(R.id.txt_list_name);
        btnSaveList = findViewById(R.id.btnSaveList);

        // Save list button
        btnSaveList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String listName = txtListName.getText().toString().trim();
                if (listName.isEmpty()) {
                    Toast.makeText(AddList.this, "Voer een lijstnaam in", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(AddList.this, Dashboard.class);
                    intent.putExtra("NEW_LIST_NAME", listName);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddList.this, Dashboard.class));
                finish();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddList.this, ProfileActivity.class));
                finish();
            }
        });

        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddList.this, FavoritePage.class));
                finish();
            }
        });
    }
}