package com.example.sellgg;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A fragment that takes in user search keywords
 */

public class SearchFragment extends Fragment {
    private Searcher searchItem; //Instance of searched item
    private EditText si; //Used to input keyword
    private String kw; //Used to store keyword

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
        View view =  inflater.inflate(R.layout.fragment_search, container, false);

         // Creates a button and sets it to the button w/ id search_button
         // so that it can be given an onClickListener
         Button searchButton = (Button) view.findViewById(R.id.search_button);

         // User inputted text for what is to be searched
         si = (EditText) view.findViewById(R.id.search);

         //OnClick method that sends the keyword to the search results activity
             searchButton.setOnClickListener(new OnClickListener() {

                 /*
                  * Overrides the onClick method from the onClickListener class to call the
                  * openSearchResultsActivity method
                  */
                 @Override
                 public void onClick(View v) {
                     kw = si.getText().toString();
                     SearchResults.setString(kw);
                     openSearchResultsActivity();
                 }
             });
        return view;
    }

    /**
     * Opens the SearchResults activity class
     */
    public void openSearchResultsActivity() {
        Intent searched = new Intent(getActivity(), SearchResults.class);
        startActivity(searched);
    }
}

