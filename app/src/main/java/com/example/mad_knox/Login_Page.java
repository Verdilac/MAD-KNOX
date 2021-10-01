package com.example.mad_knox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Page extends AppCompatActivity {

    // Initializing components
    private EditText login_email, login_password;
    private Button login_btn;
    private TextView register;

    // Firebase Instance
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Firebase Initialization
        mAuth = FirebaseAuth.getInstance();

        login_email = (EditText) findViewById(R.id.login_email);
        login_password = (EditText) findViewById(R.id.login_password);
        login_btn = (Button) findViewById(R.id.login_btn);
        register = (TextView) findViewById(R.id.register);

        // Register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterPage();
            }
        });

        // Login
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });

    }

    public void openRegisterPage () {
        Intent register_page_intent = new Intent(Login_Page.this,Register_Page.class);
        startActivity(register_page_intent);
    }

    private void userLogin() {

        // Obtain user credential and convert to string
        String u_email = login_email.getText().toString().trim();
        String u_password = login_password.getText().toString().trim();

        // Validation
        if(u_email.isEmpty()){
            login_email.setError("Email is required");
            login_email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(u_email).matches()){
            login_email.setError("Invalid Email");
            login_email.requestFocus();
            return;
        }

        if(u_password.isEmpty()){
            login_password.setError("Password is required");
            login_password.requestFocus();
            return;
        }

        if(u_password.length() < 6){
            login_password.setError("There should be more than 6 characters");
            login_password.requestFocus();
            return;
        }


        // Sign-in user with Firebase
        mAuth.signInWithEmailAndPassword(u_email,u_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                // Check if user has been logged in
                if(task.isSuccessful()){

                    // Log-in successful, redirect to home page
                    Intent home_intent = new Intent(Login_Page.this,Home_Page.class);
                    startActivity(home_intent);

                }
                else {
                    Toast.makeText(Login_Page.this, "Invalid Login Credentials, try again!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}