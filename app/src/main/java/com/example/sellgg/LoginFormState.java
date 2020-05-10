package com.example.sellgg;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
class LoginFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;
    private boolean isDataValid;

    /**
     * @param usernameError
     * @param passwordError
     */
    LoginFormState(@Nullable Integer usernameError, @Nullable Integer passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    /**
     * @param isDataValid
     */
    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    /**
     * @return usernameError
     */
    @Nullable
    Integer getUsernameError() {

        return usernameError;
    }

    /**
     * @return passwordError
     */
    @Nullable
    Integer getPasswordError() {

        return passwordError;
    }

    /**
     * @return isDataValid
     */
    boolean isDataValid() {

        return isDataValid;
    }
}
