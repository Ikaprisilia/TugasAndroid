package com.example.tugasandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText fullname, username, email, phonenumber, password;
    Button register, cancle;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phonenumber = findViewById(R.id.phonenumber);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        cancle = findViewById(R.id.cancle);

        preferences = getSharedPreferences("Userinfo", 0);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullnameValue = fullname.getText().toString();
                String usernameValue = username.getText().toString();
                String emailValue = email.getText().toString();
                String phonenumberValue = phonenumber.getText().toString();
                String passwordValue = password.getText().toString();

                if(usernameValue.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("fullname", fullnameValue);
                    editor.putString("username", usernameValue);
                    editor.putString("email", emailValue);
                    editor.putString("phonenumber", phonenumberValue);
                    editor.putString("password", passwordValue);
                    editor.apply();
                    Toast.makeText(Register.this, "User registered!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Register.this, "enter value in the fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyField();
            }
        });
    }
    public void emptyField(){
        fullname.setText("");
        username.setText("");
        email.setText("");
        phonenumber.setText("");
        password.setText("");
    }
}