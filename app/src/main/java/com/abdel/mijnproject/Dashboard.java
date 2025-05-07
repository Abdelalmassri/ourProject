package com.abdel.mijnproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.abdel.mijnproject.Activity.AddList;
import com.abdel.mijnproject.Activity.FavoritePage;
import com.abdel.mijnproject.Activity.ListDetailActivity;
import com.abdel.mijnproject.Activity.ProfilePage;

import java.util.ArrayList;

public class Dashboard extends Activity {
    ImageView btn_add, btn_favorite, btn_profile, btn_menu;
    LinearLayout listsContainer;

    public static ArrayList<String> shoppingLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize views
        btn_profile = findViewById(R.id.btn_profile);
        btn_favorite = findViewById(R.id.btn_favorite);
        btn_menu = findViewById(R.id.btn_menu);
        btn_add = findViewById(R.id.btn_add);
        listsContainer = findViewById(R.id.lists_container);

        refreshLists();

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("NEW_LIST_NAME")) {
            String newList = intent.getStringExtra("NEW_LIST_NAME");
            shoppingLists.add(newList);
            refreshLists();
        }

        // Navigation buttons
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, AddList.class));
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, ProfilePage.class));
            }
        });

        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, FavoritePage.class));
            }
        });
    }

    private void refreshLists() {
        listsContainer.removeAllViews();

        for (final String listName : shoppingLists) {
            Button listButton = new Button(this);
            listButton.setText(listName);
            listButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Dashboard.this, ListDetailActivity.class);
                    intent.putExtra("LIST_NAME", listName);
                    startActivity(intent);
                }
            });

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, 20);
            listButton.setLayoutParams(params);

            listsContainer.addView(listButton);
        }
    }
}