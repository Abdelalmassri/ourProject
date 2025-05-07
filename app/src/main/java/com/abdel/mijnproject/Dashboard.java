package com.abdel.mijnproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;  // ImageButton i.p.v. ImageView
import android.widget.LinearLayout;

import com.abdel.mijnproject.Activity.AddList;
import com.abdel.mijnproject.Activity.FavoritePage;
import com.abdel.mijnproject.Activity.ListDetailActivity;
import com.abdel.mijnproject.Activity.ProfileActivity;

import java.util.ArrayList;

public class Dashboard extends Activity {
    ImageButton btn_add, btn_favorite, btn_profile, btn_menu;
    LinearLayout listsContainer;

    public static ArrayList<String> shoppingLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialiseer views
        btn_profile = findViewById(R.id.btn_profile);
        btn_favorite = findViewById(R.id.btn_favorite);
        btn_menu = findViewById(R.id.btn_menu);
        btn_add = findViewById(R.id.btn_add);
        listsContainer = findViewById(R.id.lists_container);  // Zorg dat ID overeenkomt met XML

        refreshLists();

        // Verwerk nieuwe lijst van AddList (indien beschikbaar)
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("NEW_LIST_NAME")) {
            String newList = intent.getStringExtra("NEW_LIST_NAME");
            shoppingLists.add(newList);
            refreshLists();
        }

        // Klikluisteraars met standaard Intent-aanroepen
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addListIntent = new Intent(Dashboard.this, AddList.class);
                startActivity(addListIntent);
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(Dashboard.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        });

        btn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoriteIntent = new Intent(Dashboard.this, FavoritePage.class);
                startActivity(favoriteIntent);
            }
        });
    }

    private void refreshLists() {
        if (listsContainer == null || shoppingLists == null) return;  // Voorkom NullPointerException

        listsContainer.removeAllViews();  // Maak de container leeg voordat je nieuwe lijsten toevoegt

        for (final String listName : shoppingLists) {
            Button listButton = new Button(this);
            listButton.setText(listName);
            listButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detailIntent = new Intent(Dashboard.this, ListDetailActivity.class);
                    detailIntent.putExtra("LIST_NAME", listName);
                    startActivity(detailIntent);
                }
            });

            // Layout parameters instellen (met margins in dp)
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.list_item_margin));
            listButton.setLayoutParams(params);

            listsContainer.addView(listButton);
        }
    }
}