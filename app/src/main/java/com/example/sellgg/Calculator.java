package com.example.sellgg;
import android.annotation.SuppressLint;

import java.util.ArrayList;

/**
* This class uses the Searcher class and sifts through its ArrayList to calculate
* the average price the user could use to list or the Sellgg undercut price
 */
public class Calculator {

    private Searcher s = new Searcher();

    /**
     * Default Constructor
     */
    public Calculator() {
    }

    /**
     * Sets the search item to that equal to user input
     */
    public void setS(Searcher s){
        this.s = s;
    }
    /**
     * Calculates the average listed price
     * @return average
     */

    public String getAveragePrice() {

        ArrayList<SearchedItem> table = s.getResults();
        double total = 0;
        double avg = 0;
        String average = "";

        // Runs through the ArrayList of SearchedItem objects from Searcher and totals the prices
        for (int j = 0; j < table.size(); j++) {

            double d = table.get(j).getPrice();

            total += d;
        }


        avg =  total / table.size();

        average = String.format("%.02f",avg);



        return average;
    }

    /**
    * Calculates the price suggested to list from Sellgg
    * @return sellggPrice
    */
    public String getSellggPrice() {

        ArrayList<SearchedItem> table = s.getResults();
        double total = 0;
        double sellgg = 0;
        String sellggPrice = "";

        // Runs through the ArrayList of SearchedItem objects from Searcher and totals the prices
        for (int i = 0; i < table.size(); i++) {

            double d = table.get(i).getPrice();

            total += d;
        }

        sellgg = (total / table.size()) * (0.85);

        sellggPrice = String.format("%.02f", sellgg);

        return sellggPrice;

    }
}
