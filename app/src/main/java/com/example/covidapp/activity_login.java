package com.example.covidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class activity_login extends AppCompatActivity {
    EditText phone2;
    EditText password;
    Button register;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            setupUI();
            setupListeners();
        }

    private void setupUI() {
        phone2 = findViewById(R.id.phone2);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
    }
    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUsername();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity_login.this, MainActivity .class);
                startActivity(i);

            }
        });

    }
    void checkUsername() {
        boolean isValid = true;
        if (isEmpty(phone2)) {
            phone2.setError("You must enter Phone number to login!");
            isValid = false;
        } else {
            isphone(phone2);
        }

        if (isEmpty(password)) {
            password.setError("You must enter password to login!");
            isValid = false;
        } else {
            if (password.getText().toString().length() < 4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }

        //check email and password
        //IMPORTANT: here should be call to backend or safer function for local check; For example simple check is cool
        //For example simple check is cool
        if (isValid) {
            String phoneValue = phone2.getText().toString();
            String passwordValue = password.getText().toString();
            if (phoneValue.equals("9080321851") && passwordValue.equals("password1234")) {
                //everything checked we open new activity
                //Intent i = new Intent(activity_login.this, activity_login.class);
                //startActivity(i);
                //we close this activity
                Intent i = new Intent(activity_login.this, result_activity .class);
                startActivity(i);
                this.finish();
            } else {
                Toast t = Toast.makeText(this, "Wrong Mobile or password!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }
    void isphone(EditText text) {
        String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
        Matcher m;
        Pattern r = Pattern.compile(pattern);
        if (!phone2.getText().toString().isEmpty()) {
            m = r.matcher(phone2.getText().toString().trim());
        } else {
            Toast.makeText(activity_login.this, "Please enter mobile number ", Toast.LENGTH_LONG).show();
        }
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    }

