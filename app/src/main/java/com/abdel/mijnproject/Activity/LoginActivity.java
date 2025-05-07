package com.abdel.mijnproject.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.abdel.mijnproject.Dashboard;
import com.abdel.mijnproject.R;
import com.abdel.mijnproject.data.entities.User;
import com.abdel.mijnproject.repository.OnlineUserRepository;
import com.abdel.mijnproject.repository.UserRepositoryInterface;
import com.abdel.mijnproject.utils.DialogUtils;
import com.abdel.mijnproject.utils.Session;

public class LoginActivity extends Activity {

    Button btn_login;
    TextView btn_signup, txt_forgot_password;
    EditText txt_email, txt_password;

    private UserRepositoryInterface loginRepositoryInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(Session.isLogin(LoginActivity.this)){
            startActivity(new Intent(LoginActivity.this,Dashboard.class));
            finish();
        }

        btn_login= findViewById(R.id.btn_login);
        btn_signup= findViewById(R.id.btn_signup);
        txt_email= findViewById(R.id.txt_email);
        txt_password= findViewById(R.id.txt_password);
        txt_forgot_password=findViewById(R.id.txt_forgot_password);
        loginRepositoryInterface=new OnlineUserRepository();
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        txt_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }

            private void login() {
                String emailtId = txt_email.getText().toString();
                String password = txt_password.getText().toString();
                loginRepositoryInterface.login(emailtId, password, new UserRepositoryInterface.ValidateCallBack() {
                    @Override
                    public void onSuccess(User user) {
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Session.saveUserDetail(getApplicationContext(),user);
                        startHomepage();
                    }

                    @Override
                    public void onError(String errormessage) {
                        DialogUtils.showOkDialog(LoginActivity.this,"Error",errormessage);
                    }
                } );
            }

            private void startHomepage() {
                Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                startActivity(intent);
                finish(); // Close login activity
            }
        });

    }
}