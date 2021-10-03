package com.example.mad_knox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register_Page extends AppCompatActivity {

    // Initializing components
    private EditText reg_name, reg_email, reg_phone, reg_password;
    private Button register_btn;
    private ImageView back_arrow_btn;

    // Firebase Instance
    private FirebaseAuth mAuth;

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


        // Firebase Initialization
        mAuth = FirebaseAuth.getInstance();


        // Back_arrow
        back_arrow_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_intent = new Intent(Register_Page.this, Login_Page.class);
                startActivity(back_intent);
            }
        });


        // Register btn clicked
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }

    private void registerUser() {

        // Obtaining the input as text then converting to string, then trim it and pass to the variable.
        String name = reg_name.getText().toString().trim();
        String phone = reg_phone.getText().toString().trim();
        String email = reg_email.getText().toString().trim();
        String password = reg_password.getText().toString().trim();

        // Validations
        if (name.isEmpty()){
            reg_name.setError("Name is required");
            reg_name.requestFocus();  // focus back on the name field
            return;
        }

        if (phone.isEmpty()){
            reg_phone.setError("Phone number is required");
            reg_phone.requestFocus();
            return;
        }

        if (phone.length() != 10){
            reg_phone.setError("Phone number should have 10 digits");
            reg_phone.requestFocus();
            return;
        }

        if(!Patterns.PHONE.matcher(phone).matches()){
            reg_phone.setError("Invalid phone number");
            reg_phone.requestFocus();
            return;
        }

        if (email.isEmpty()){
            reg_email.setError("Email is required");
            reg_email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){  // Checks if the email address matches the pattern
            reg_email.setError("Invalid Email");
            reg_email.requestFocus();
            return;
        }

        if (password.isEmpty()){
            reg_password.setError("Password is required");
            reg_password.requestFocus();
            return;
        }

        if (password.length() < 6){
            reg_password.setError("Password should have more than 6 characters");
            reg_password.requestFocus();
        }

        // Setting visibility of progress bar
        // progressBar.setVisibility(View.VISIBLE);

        // Firebase Authentication (Creating user with email and password by passing above created variables as parameters)
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // Check if user has been registered
                        if(task.isSuccessful()){


                            // If so create user object
                            UserData user = new UserData(name,phone,email);

                            // Send user object to real-time db in Firebase
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Register_Page.this, "User has been registered successfully", Toast.LENGTH_LONG).show();


                                        // Then redirect to the login page
                                        Intent login_redirect_intent = new Intent(Register_Page.this,Login_Page.class);
                                        startActivity(login_redirect_intent);
                                    }

                                    else{
                                        Toast.makeText(Register_Page.this, "Failed to register", Toast.LENGTH_LONG).show();
                                        // progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });

                        }
                        else{
                            Toast.makeText(Register_Page.this, "Failed to register user", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }



}

// New Activity Creation : https://www.youtube.com/watch?v=bgIUdb-7Rqo&t=17s