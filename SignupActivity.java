package com.abdel.mijnproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.abdel.mijnproject.R;
import com.abdel.mijnproject.utils.DialogUtils;

public class SignupActivity extends Activity {

    Toolbar toolbar;
    EditText txt_name, txt_dob, txt_email, txt_password, txt_cofpass;
    Button btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);
        getActionBar().setTitle("Sign Up");
        getActionBar().setDisplayHomeAsUpEnabled(true);

        txt_name = findViewById(R.id.txt_name);
        txt_dob = findViewById(R.id.txt_dob);
        txt_email = findViewById(R.id.txt_email);
        txt_password = findViewById(R.id.txt_password);
        txt_cofpass = findViewById(R.id.txt_cofpass);
        btn_signup = findViewById(R.id.btn_signup);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        txt_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils.showDatePickerDialog(SignupActivity.this, new DialogUtils.DatePickerCallback() {
                    @Override
                    public void onDateSelected(int year, int month, int day) {
                        String selectedDate = day + "/" + (month + 1) + "/" + year;
                        txt_dob.setText(selectedDate);
                    }
                });
            }
        });
    }

    private void register() {
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}