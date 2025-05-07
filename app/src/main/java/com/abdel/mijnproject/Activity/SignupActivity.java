package com.abdel.mijnproject.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.abdel.mijnproject.R;
import com.abdel.mijnproject.data.entities.User;
import com.abdel.mijnproject.repository.OnlineUserRepository;
import com.abdel.mijnproject.repository.UserRepositoryInterface;
import com.abdel.mijnproject.utils.DialogUtils;

public class SignupActivity extends Activity {

    Toolbar toolbar;
    EditText txt_name, txt_dob, txt_email, txt_password, txt_cofpass;
    Button btn_signup;

    private UserRepositoryInterface userRepositoryInterface;

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
        userRepositoryInterface=new OnlineUserRepository();
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }

            private void register() {
                String name = txt_name.getText().toString().trim();
                String dob = txt_dob.getText().toString().trim();
                String email = txt_email.getText().toString().trim();
                String password = txt_password.getText().toString().trim();
                String cofpass = txt_cofpass.getText().toString().trim();
                if(validateFrom()){
                    userRepositoryInterface.signUp(new User(name, dob, email, password), new UserRepositoryInterface.SaveCallBack() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(SignupActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            finish(); // Close registration activity
                        }

                        @Override
                        public void onError(String errorMessage) {
                            DialogUtils.showOkDialog(SignupActivity.this, "Sign Up Error", errorMessage);
                        }
                    });
                }
            }

            private boolean validateFrom() {
                boolean isValid = true;

                // Retrieve data from form fields
                String name = txt_name.getText().toString().trim();
                String age = txt_dob.getText().toString();
                String email = txt_email.toString(); // Assuming you are using MaskedEditText
                String password = txt_password.getText().toString();
                String confirmPassword = txt_cofpass.getText().toString();

                // Reset any previous errors
                txt_name.setError(null);
                txt_dob.setError(null);
                txt_email.setError(null);
                txt_password.setError(null);
                txt_cofpass.setError(null);

                // Check if Name field is empty
                if (TextUtils.isEmpty(name)) {
                    txt_name.setError("Name is required");
                    isValid = false;
                }

                if (!name.matches("[a-zA-Z ]+")) {
                    txt_name.setError("alphabetic characters only");
                    isValid = false;

                }


                // Check if DOB field is empty
                if (TextUtils.isEmpty(age)) {
                    txt_dob.setError("DOB is required");
                    isValid = false;
                }

                // Check if CNIC field is empty
                if (TextUtils.isEmpty(email)) {
                    txt_email.setError("email is required");
                    isValid = false;
                }

                // Check if Password field is empty
                if (TextUtils.isEmpty(password)) {
                    txt_password.setError("Password is required");
                    isValid = false;
                }

                if (password.length() < 4) {
                    txt_password.setError("Password is very short");
                    isValid = false;
                }

                // Check if Confirm Password field is empty
                if (TextUtils.isEmpty(confirmPassword)) {
                    txt_cofpass.setError("Confirm Password is required");
                    isValid = false;
                }

                // Check if passwords match
                if (!password.equals(confirmPassword)) {
                    txt_cofpass.setError("Passwords do not match");
                    isValid = false;
                }

                return isValid;

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



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
    

}