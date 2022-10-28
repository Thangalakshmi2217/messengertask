package com.messenger.orm;

/**
 * <p>
 *     An {@link Enum} which contains column names of {@link Message} table.
 * </p>
 */
public enum Message {
    messageId("message_id"),
    profileId("user_id"),
    contactId("contact_id"),
    messageTime("message_time"),
    messageDetails("message_details");

    private String columnName;

    Message(final String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}