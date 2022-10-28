package com.messenger.authentication.model;

import com.messenger.validation.AuthenticationGroup.Select;
import com.messenger.validation.AuthenticationGroup.Insert;
import com.messenger.validation.AuthenticationGroup.Delete;
import com.messenger.validation.AuthenticationGroup.Update;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * <p>
 *     A model which represents the {@link UserDetail}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class UserDetail {
    @Positive(groups = {Select.class, Update.class, Delete.class})
    @Min(value = 1, message = "Userid should have at least 1 character", groups = {Select.class, Update.class,
            Delete.class})
    private long userId;
    @NotEmpty(message = "userName must not be empty", groups = Insert.class)
    @Size(min = 3, message = "username should have at least contain 3 Character", groups = Insert.class)
    @Pattern(regexp = "(^[a-zA-Z_]{3,40}$)", message = "username Contain only alphabets and underscore",
            groups = Insert.class)
    private String userName;
    @Password(groups = {Insert.class, Update.class})
    private String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}