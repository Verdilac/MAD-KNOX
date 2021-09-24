package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Register_Page extends AppCompatActivity {

    // Initializing components
    private EditText reg_name, reg_email, reg_phone, reg_password;
    private Button register_btn;
    private ImageView back_arrow_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        reg_name = (EditText) findViewById(R.id.reg_name);
        reg_email = (EditText) findViewById(R.id.reg_email);
        reg_phone = (EditText) findViewById(R.id.reg_phone);
        reg_password = (EditText) findViewById(R.id.reg_password);
        register_btn = (Button) findViewById(R.id.register_btn);
        back_arrow_btn = (ImageView) findViewById(R.id.back_arrow_btn);


        // Back_arrow
        back_arrow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_intent = new Intent(Register_Page.this, Login_Page.class);
                startActivity(back_intent);
            }
        });



    }
}

// New Activity Creation : https://www.youtube.com/watch?v=bgIUdb-7Rqo&t=17s