package com.example.sellgg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;




import java.util.UUID;

/**
 * Activity for user registration
 */
public class SignUp extends AppCompatActivity
{
    private Button register; //button to register the user
    private EditText etFirstName, etLastName, etUserName, etEmail, etPassword; //info needed to be put in by user

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.sellgg.R.layout.activity_sign_up);

        etFirstName = (EditText) findViewById(R.id.etFirstName); //user first name input
        etLastName = (EditText) findViewById(R.id.etLastName); // user last name input
        etUserName = (EditText) findViewById(R.id.etUserName); // user username input
        etEmail = (EditText) findViewById(R.id.etEmail); // user email input
        etPassword = (EditText) findViewById(R.id.etPassword); // user password input
        register = (Button) findViewById(R.id.registerButton); //user register button

        /**
         * OnClick the users info is used to created a User object that will store their information to be sent to
         * the account fragment page for display and the loggedInUserView for the log in display message
         */
        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UUID uuid = UUID.randomUUID();
                User user = new User(etUserName.getText().toString(), etFirstName.getText().toString(), etLastName.getText().toString(),
                        etEmail.getText().toString(), etPassword.getText().toString(), uuid);
                AccountFragment.setUser(user);
                LoggedInUserView.setUser(user);
                openLoginActivity();
            }
        });
    }

    /**
     * For opening the LoginActivity class activity
     */
    public void openLoginActivity()
    {
        Intent login = new Intent(SignUp.this, LoginActivity.class);
        startActivity(login);
    }

}