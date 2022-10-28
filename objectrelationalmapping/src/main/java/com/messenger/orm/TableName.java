package com.messenger.orm;

/**
 * <p>
 *     An {@link Enum} which holds the table names.
 * </P>
 */
public enum TableName {
    user_login,
    user_contact,
    user_message;

    private String tableName;

    TableName() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}