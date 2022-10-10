package com.messenger.conversation.dao;

import com.messenger.orm.ORMImpl;
import com.messenger.orm.TableName;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Establishes the {@link Connection} to the database and executes the CRUD operation.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class ContactDAO {

    private static final ORMImpl ORM_IMPL = ORMImpl.getInstance();

    /**
     * <p>
     *     Gets the specific user contact.
     * </p>
     *
     * @param tableName        represents name of the table
     * @param columnList       represents the {@link List} of columns
     * @param conditionColumn  gets the value by giving a certain condition
     * @return the {@link Collection} of user contacts
     */
    public Collection<Map<String, Object>> getUserContact(final Enum<TableName> tableName,
                                                          final List<String> columnList,
                                                          final Map<String, Object> conditionColumn) {
        return ORM_IMPL.getParticularDetailsById(tableName, columnList, conditionColumn);
    }

    /**
     * <p>
     *     Inserted a new user contact.
     * </p>
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return true when the contact is inserted
     */
    public Boolean addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return ORM_IMPL.insert(tableName, objectDetails);
    }

    /**
     * <p>
     *     Updated specific user's mobile number.
     * </p>
     *
     * @param tableName       represents name of the table
     * @param objectDetails   represents the contact details
     * @param conditionColumn obtaining a value from the column by stating the condition
     * @return true when the mobile number is updated
     */
    public Boolean updateMobileNumber(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                      final Map<String, Object> conditionColumn) {
        return ORM_IMPL.update(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Removed specific user contacts in the database.
     * </p>
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return true when the specific user contact is deleted
     */
    public Boolean deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return ORM_IMPL.delete(tableName, objectDetails);
    }
}