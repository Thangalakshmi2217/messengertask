package com.messenger.conversation.service.conversationService;

import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Provides {@link ContactService}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public interface ContactService {

    /**
     * <p>
     *     Retrieves the user contact.
     * </p>
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return the particular user contact
     */
    Collection<Map<String, Object>> getUserContact(final Enum<TableName> tableName,
                                                   final List<String> columnList,
                                                   final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Creates new contact.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the contact details
     * @return the generated status
     */
    String addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails);

    /**
     * <p>
     *     Updates the mobile number.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents contact details
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the updated status
     */
    String updateMobileNumber(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                              final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Deletes the user contact.
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the contact details
     * @return the deleted status
     */
    String deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails);
}