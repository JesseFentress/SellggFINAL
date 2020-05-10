package com.example.sellgg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This class is for the activity of the main screen that is generated when Sellgg is opened
 */
public class MainActivity extends AppCompatActivity
{
    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates a button set to the button w/ id loginButton
        Button loginButton = (Button) findViewById(R.id.loginButton);

        // Sets onClickListener to the loginButton
        loginButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openLoginActivity();
            }
        });

        // Creates a button set to the button w/ id signUpButton
        Button signUpButton = (Button) findViewById(R.id.signUpButton);

        // Sets onClickListener to the signUpButton
        signUpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });
    }

    /**
    * Opens the LoginActivity activity
    */
    public void openLoginActivity()
    {
        // Creates a new intent that will open the LoginActivty activtiy class
        Intent login = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(login);
    }

    /**
    * Opens the SignUp activity
    */
    public void openSignUp()
    {
        // Creates a new intent that will open up the SignUp activity class
        Intent signUp = new Intent(MainActivity.this, SignUp.class);
        startActivity(signUp);
    }
}
