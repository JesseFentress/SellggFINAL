package com.example.sellgg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * Fragment that display account info and has a link to settings fragment to change info
 */
public class AccountFragment extends Fragment {


    private static User acc; // Creates instance of user object to be displayed on page


    /**
     * Method to display all the users information
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        TextView username = (TextView) view.findViewById(R.id.username);

        username.setText(acc.getUsername());

        TextView email = (TextView) view.findViewById(R.id.email);

        email.setText(acc.getEmail());

        TextView password = (TextView) view.findViewById(R.id.password);

        password.setText(acc.getPassword());

        TextView listings = (TextView) view.findViewById(R.id.listings);

        listings.setText(acc.getUsername());

        TextView firstName = (TextView) view.findViewById(R.id.firstName);

        firstName.setText(acc.getFirstName());

        TextView lastName = (TextView) view.findViewById(R.id.lastName);

        lastName.setText(acc.getLastName());

        Button edit = (Button) view.findViewById(R.id.edit_settings);

        edit.setOnClickListener(new View.OnClickListener() {

            /*
             * Overrides the onClick method from the onClickListener class to call the
             * openSettingsFragment method
             */
            @Override
            public void onClick(View v) {


                openSettingsFragment();
            }
        });

        return view;
    }

    /**
     * Method used for passing a user object
     * @param user user object
     */
    public static void setUser(User user)
    {
        acc = user;
    }

    /**
     * Opens the SettingsFragment
     */
    public void openSettingsFragment() {

        // Creates a FragmentTransaction to replace the current fragment with SettingsFragment
        FragmentTransaction settings = getParentFragmentManager().beginTransaction();
        settings.replace(R.id.fragment_container, new SettingsFragment());
        settings.commit();
        SettingsFragment.setUser(acc);

    }
}