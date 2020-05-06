package com.example.sellgg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.sellgg.ui.login.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.CollationElementIterator;


public class AccountFragment extends Fragment {


    public User acc = new User();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        TextView username = (TextView) view.findViewById(R.id.username);

        username.setText(acc.getUsername());

        TextView email = (TextView) view.findViewById(R.id.email);

        username.setText(acc.getEmail());

        TextView password = (TextView) view.findViewById(R.id.password);

        username.setText(acc.getPassword());

        TextView listings = (TextView) view.findViewById(R.id.listings);

        username.setText(acc.getUsername());

        return view;
    }

}
