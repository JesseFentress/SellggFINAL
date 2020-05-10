package com.example.sellgg;

/**
 * Class to hold the title and price of objects for the Searcher class
 */
public class SearchedItem {

    String title; //Listing title
    double price; //Listing Price

    public SearchedItem() {
    }

    /**
     * Constructor
     * @param title Title of listing
     * @param price Price of listing
     */
    public SearchedItem(String title, double price) {
        this.title = title;
        this.price = price;
    }

    /**
     * Gets Title of listing
     * @return Title of listing
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets Title of listing
     * @param title tiele of listing
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets listing price
     * @return listing price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets listing price
     * @param price listing price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
