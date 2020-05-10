package com.example.sellgg;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class LoginResult {
    @Nullable
    private LoggedInUserView success;
    @Nullable
    private Integer error;

    /**
     * @param error
     */
    LoginResult(@Nullable Integer error) {
        this.error = error;
    }

    /**
     * @param success
     */
    LoginResult(@Nullable LoggedInUserView success) {
        this.success = success;
    }

    /**
     * @return success
     */
    @Nullable
    LoggedInUserView getSuccess() {
        return success;
    }

    /**
     * @return error
     */
    @Nullable
    Integer getError() {
        return error;
    }
}
