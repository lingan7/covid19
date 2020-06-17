package com.example.covidapp;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity
{
    EditText firstName;
    EditText lastName;
    EditText password;
    EditText phone1;
    Button register;
    Button login;
    String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    Matcher m;
    private Notification.MessagingStyle.Message text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        password = findViewById(R.id.password);
        phone1 = findViewById(R.id.phone1);
        register = findViewById(R.id.register);
        login=findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, activity_login .class);
                startActivity(i);
            }
        });

        }
        boolean isEmpty(EditText text) {
            CharSequence str = text.getText().toString();
            return TextUtils.isEmpty(str);
        }
        void checkDataEntered()
        {
            if (isEmpty(firstName)) {
                Toast t = Toast.makeText(this, "You must enter first name to register!", Toast.LENGTH_SHORT);
                t.show();
            }
            if (isEmpty(lastName)) {
                lastName.setError("Last name is required!");
            }

            Pattern r = Pattern.compile(pattern);
            if (!phone1.getText().toString().isEmpty()) {
                m = r.matcher(phone1.getText().toString().trim());
            } else {
                Toast.makeText(MainActivity.this, "Please enter mobile number ", Toast.LENGTH_LONG).show();
            }

        }

    }

