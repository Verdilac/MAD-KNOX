package com.example.mad_knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_Page extends AppCompatActivity {

    private ImageView hamburger_menu;
    private ImageView profile_btn;
    private ImageView cart_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        profile_btn = (ImageView) findViewById(R.id.profile_btn);

        // Profile Btn
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_page_intent = new Intent(Home_Page.this, Login_Page.class);
                startActivity(login_page_intent);
            }
        });

    }
}

// Card View to New Activity : https://www.youtube.com/watch?v=DocKN8yX9qc