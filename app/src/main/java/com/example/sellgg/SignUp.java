package com.example.sellgg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;



import com.example.sellgg.ui.login.LoginActivity;
import com.example.sellgg.ui.login.User;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.UUID;

public class SignUp extends AppCompatActivity
{
    Button register;
    EditText etFirstName, etLastName, etUserName, etEmail, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.sellgg.R.layout.activity_sign_up);

        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        register = (Button) findViewById(R.id.registerButton);

        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UUID uuid = UUID.randomUUID();
                User user = new User(etUserName.getText().toString(), etFirstName.getText().toString(), etLastName.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString(), uuid);
                openLoginActivity();
            }
        });
    }




    public void openLoginActivity()
    {
        Intent login = new Intent(SignUp.this, LoginActivity.class);
        startActivity(login);
    }
}
