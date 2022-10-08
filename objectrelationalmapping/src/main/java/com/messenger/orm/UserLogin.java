package com.messenger.orm;

/**
 * <p>
 *     An {@link Enum} that contains the column names of the {@link UserLogin}table.
 * </p>
 */
public enum UserLogin {
    userId("user_id"),
    userName("user_name"),
    password("password");

    private String columnName;

    UserLogin(final String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}