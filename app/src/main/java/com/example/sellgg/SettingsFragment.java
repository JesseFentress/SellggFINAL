package com.example.sellgg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * Fragment that lets the user change their account information
 */
public class SettingsFragment extends Fragment {

    private static User acc; // User object to be edited
    private EditText userName, password, email; // Edit Texts for taking in input
    private Button save; // Button saves the new information

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setttings, container, false);

        userName = (EditText) view.findViewById(R.id.new_uname);

        password = (EditText) view.findViewById(R.id.new_pswd);

        email = (EditText) view.findViewById(R.id.new_email);

        save = (Button) view.findViewById(R.id.save_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acc.setUsername(userName.getText().toString());
                acc.setPassword(password.getText().toString());
                acc.setEmail(email.getText().toString());

                AccountFragment.setUser(acc);
                openAccountFragment();

            }
        });


        return view;

    }

    /**
     * Method for receiving the users information
     * @param user User obj
     */
    public static void setUser(User user){
        acc = user;
    }

    /**
     * For opening the AcctoungFragment class fragment
     */
    public void openAccountFragment() {

        // Creates a FragmentTransaction to replace the current fragment with SettingsFragment
        FragmentTransaction settings = getParentFragmentManager().beginTransaction();
        settings.replace(R.id.fragment_container, new AccountFragment());
        settings.commit();

    }
}
