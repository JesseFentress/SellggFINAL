package com.example.sellgg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.os.Bundle;

import com.example.sellgg.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openLoginActivity();
            }
        });

        Button signUpButton = (Button) findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });
    }
    public void openLoginActivity()
    {
        Intent login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(login);
    }

    public void openSignUp()
    {
        Intent signUp = new Intent(MainActivity.this, SignUp.class);
        startActivity(signUp);
    }
}
