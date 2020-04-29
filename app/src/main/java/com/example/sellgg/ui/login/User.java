package com.example.sellgg.ui.login;

import android.widget.EditText;
import java.util.*;

public class User
{
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected UUID userID;
    //protected MyProducts listings;

    /**
     *
     */
    public User() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param username
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param userID
     */
    public User(String username, String firstName, String lastName, String email, String password, UUID userID) {
        super();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userID = userID;

    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userID
     */
    public UUID getUserID() { return userID; }

    /**
     * @param userID the userID to set
     */
    public void setUUID(UUID userID) { this.userID = userID; }

    @Override
    public String toString() {
        return "User [username=" + username + ", email=" + email + ", password=" + password + ", listings="
                + "]";
    }


}


