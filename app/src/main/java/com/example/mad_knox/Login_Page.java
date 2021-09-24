package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Page extends AppCompatActivity {

    // Initializing components
    private EditText login_email, login_password;
    private Button login_btn;
    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

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

    }

    public void openRegisterPage () {
        Intent register_page_intent = new Intent(Login_Page.this,Register_Page.class);
        startActivity(register_page_intent);
    }
}