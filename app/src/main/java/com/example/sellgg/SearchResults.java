package com.example.sellgg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Activity that displays the search results
 */
public class SearchResults extends AppCompatActivity {
    private TextView tv; // Used to display average pricing
    private TextView vt; // Used to display Sell.gg recommended pricing
    private static Calculator search = new Calculator(); // Creates instance of calculator that calculates above prices
    private static Searcher is = new Searcher(); // Creates instance of Searcher that is used to be passed to calculator class
    private static String wk; // Creates a string which is where the used inputted keyword is passed to

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        //Button to calculate price results
        Button results = (Button) findViewById(R.id.big);

        results.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);


                    tv = findViewById(R.id.view_results);
                    vt = findViewById(R.id.view_sellgg);
                    is.setKeyword(wk);
                    search.setS(is);
                    tv.setText("$" + search.getAveragePrice());
                    vt.setText("$" + search.getSellggPrice());


                }
            }
        });

    }

    /**
     * Method previous used to pass a Searcher object that had the keyword set but ran into bugs
     * @param searchItem Searched Item
     */
    public static void getSearcher(Searcher searchItem){ is = searchItem;}

    /**
     * Method used for passing keyword string for search results
     * @param kw keyword
     */
    public static void setString(String kw){
        wk = kw;
    }

}



