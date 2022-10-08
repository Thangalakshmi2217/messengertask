package com.messenger.orm;

/**
 * <p>
 *     An {@link Enum} that contains the column names of the {@link Contact} table.
 * </p>
 */
public enum Contact {
    profileId("user_id"),
    contactId("contact_id"),
    mobileNumber("mobile_number"),
    personName("person_name");

    private String columnName;

    Contact(final String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}