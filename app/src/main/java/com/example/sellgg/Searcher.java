package com.example.sellgg;

import android.os.AsyncTask;

import com.example.sellgg.SearchedItem;

import java.util.*;
import java.net.*;
import java.io.*;
import org.json.simple.parser.*;
import org.json.simple.parser.ParseException;
import java.net.MalformedURLException;
import org.json.simple.*;

import javax.net.ssl.HttpsURLConnection;

/**
 * This class uses the Ebay Production Finding API URL to search for 100 items that are found
 * with keywords set by the user
 */
public class Searcher {

    public String URL = "https://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findItemsByKeywords&OPERATION-NAME=findItemsByKeywords&SERVICE-NAME=FindinService&SERVICE-VERSION=1.0.0&GLOBAL-ID=EBAY-US&SECURITY-APPNAME=JesseFen-MyApp-PRD-67aae6145-dbf68883&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&paginationsInput.entriesPerPage=15&keywords=";
    public String keyword ="naga";

    /**
     * Default constructor
     */
    public Searcher() {
    }
    /**
     *  Constructor
     * @param URL The desired URL
     * @param keyword The desired keyword
     */
    public Searcher(String URL, String keyword) {
        this.URL = URL;
        this.keyword = keyword;
    }

    /**
     * Returns the current keyword
     * @return keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Sets the keyword and replaces any spaces with %20 to fit proper format
     * @param keyword The keyword set by the user
     */
    public void setKeyword(String keyword) {


        String space = " ";

        String newKey = "";

        // Finds any spaces and replaces them with %20
       for (int i = 0; i <keyword.length(); i++) {

            if (keyword.charAt(i) == space.charAt(0)) {

                newKey = newKey + "%20";


            } else {

                newKey = newKey + keyword.charAt(i);
            }
            this.keyword = keyword;
        }
    }

    /**
     * Returns the current URL
     * @return URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * Connects to the eBay API then takes the JSON response and parses it for the title and price
     * of each item and adds it to an ArrayList of SearchedItem objects and then returns that list
     * @return ArrayList of SearchedItem objects
     */
    public ArrayList<SearchedItem> getResults() {

        JSONParser parser = new JSONParser();
        ArrayList<SearchedItem> table = new ArrayList<>();

        try {

            // Creates URL object
            URL connection = new URL(URL + keyword);
            HttpURLConnection search = (HttpURLConnection) connection.openConnection();
            InputStream inputStream = new BufferedInputStream(search.getInputStream());
            BufferedReader bin = new BufferedReader(new InputStreamReader(inputStream));

            Object obj = parser.parse(bin);

            // Traversing the JSON Response
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray parent = (JSONArray)jsonObject.get("findItemsByKeywordsResponse");
            JSONObject child = (JSONObject)parent.get(0);
            JSONArray gchild = (JSONArray)child.get("searchResult");
            JSONObject kid = (JSONObject)gchild.get(0);
            JSONArray baby = (JSONArray)kid.get("item");

            // Looping through every entry given
            for (int i = 0; i < baby.size(); i++) {


                // Grabs titles
                JSONObject p = (JSONObject)baby.get(i);
                JSONArray c = (JSONArray)p.get("title");
                String titles = (String)c.get(0);

                // Grabs prices
                JSONObject green = (JSONObject)baby.get(i);
                JSONArray blue = (JSONArray)green.get("sellingStatus");
                JSONObject red = (JSONObject)blue.get(0);
                JSONArray yellow = (JSONArray)red.get("convertedCurrentPrice");
                JSONObject brown = (JSONObject)yellow.get(0);
                String money = (String)brown.get("__value__");
                double price = Double.valueOf(money);

                // Adds results to table ArrayList
                table.add(new SearchedItem(titles, price));
            }

        }
        // Catches any MalformedURLExceptions
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // Catches any IOExceptions
        catch (IOException e) {
            e.printStackTrace();
        }
        // Catches any ParseExceptions
        catch (ParseException e) {
            e.printStackTrace();
        }
        // Catches any NullPointerExceptions
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        // Catches any missed Exceptions
        catch (Exception e) {
            e.printStackTrace();
        }

        return table;
    }
}