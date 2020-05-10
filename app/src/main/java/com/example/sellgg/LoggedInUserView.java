package com.example.sellgg;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView extends User {
    private static User user = new User();
    private String displayName;
    //... other data fields that may be accessible to the UI

    /**
     * @param displayName
     */
    LoggedInUserView(String displayName) {

        this.displayName = " " +user.getFirstName() + "!";
    }

    /**
     * @return displayName
     */
    String getDisplayName() {

        return displayName;
    }

    /**
     * Used for sending logged in user to custom log in method
     */
    public static void setUser(User us){
        user = us;
    }

}
