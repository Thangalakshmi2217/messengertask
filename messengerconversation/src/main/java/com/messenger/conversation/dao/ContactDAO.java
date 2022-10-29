package com.messenger.conversation.dao;

import com.messenger.orm.ORMImpl;
import com.messenger.orm.TableName;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Links up the connection and manipulates the contact details into the database.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class ContactDAO {

    private static final ORMImpl ORM_IMPL = ORMImpl.getInstance();

    /**
     * <p>
     *     Retrieves the particular user contact.
     * </p>
     *
     * @param tableName        represents the table name
     * @param columnList       represents the name of table's column
     * @param conditionColumn  retrieves the value from the field based on the specific condition 
     * @return the {@link Collection} which contains the particular user contact
     */
    public Collection<Map<String, Object>> getUserContact(final Enum<TableName> tableName,
                                                          final List<String> columnList,
                                                          final Map<String, Object> conditionColumn) {
        return ORM_IMPL.getParticularDetailsById(tableName, columnList, conditionColumn);
    }

    /**
     * <p>
     *     Checks whether new contact has been created.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the contact details
     * @return true when new contact is generated
     */
    public Boolean addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return ORM_IMPL.insert(tableName, objectDetails);
    }

    /**
     * <p>
     *     Checks whether the mobile number has been updated.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents the contact details
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return true when mobile number is updated
     */
    public Boolean updateMobileNumber(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                      final Map<String, Object> conditionColumn) {
        return ORM_IMPL.update(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Checks whether user contact has been deleted.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the contact details
     * @return true when specific user contact is deleted
     */
    public Boolean deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return ORM_IMPL.delete(tableName, objectDetails);
    }
}