package com.messenger.conversation.controller;

import com.messenger.conversation.service.conversationServiceImpl.ContactServiceImpl;
import com.messenger.conversation.service.conversationServiceImpl.MessageServiceImpl;
import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Controls all the requests from the API.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class ConversationController {

    private static final ContactServiceImpl CONTACT_SERVICE = new ContactServiceImpl();
    private static final MessageServiceImpl MESSAGE_SERVICE = new MessageServiceImpl();

    /**
     * <p>
     *     Checks whether all the contacts can be obtained.
     * </p>
     *
     * @param tableName           represents name of the table
     * @param columnList          represents the {@link List} of columns
     * @param conditionColumn     getting a value from a column by specifying a condition
     * @return the {@link Collection} of user contacts
     */
    public Collection<Map<String, Object>> getUserContact(final Enum<TableName> tableName,
                                                          final List<String> columnList,
                                                          final Map<String, Object> conditionColumn) {
        return CONTACT_SERVICE.getUserContact(tableName, columnList, conditionColumn);
    }

    /**
     * <p>
     *    Checks whether the new contact can be inserted.
     * </p>
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return the inserted contact details
     */
    public String addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return CONTACT_SERVICE.addNewContact(tableName, objectDetails);
    }

    /**
     * <p>
     *     Checks whether the mobile number were updated.
     * </p>
     *
     * @param tableName       represent database table's name
     * @param objectDetails   represents the contact details
     * @param conditionColumn getting a value from a column by specifying a condition
     * @return the MobileNumber updated in the specific column
     */
    public String updateMobileNumber(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                     final Map<String, Object> conditionColumn) {
        return CONTACT_SERVICE.updateMobileNumber(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Checks whether the specific user contact is removed.
     * </p>
     *
     * @param tableName     represent name of the table
     * @param objectDetails represents the contact details
     * @return the deleted contacts
     */
    public String deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return CONTACT_SERVICE.deleteUserContact(tableName, objectDetails);
    }

    /**
     * <p>
     *     Checks whether a NewMessage is inserted
     * </p>
     *
     * @param tableName     represents the name of the table
     * @param objectDetails represents the message details
     * @return the inserted message
     */
    public String addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return MESSAGE_SERVICE.addMessage(tableName, objectDetails);
    }

    /**
     * <p>
     *    Checks whether Specific message details can be retrieved.
     * </p>
     *
     * @param tableName       represent name of the table
     * @param columnList      represents the {@link List} of columns
     * @param conditionColumn getting a value from a column by specifying a condition
     * @return the {@link Collection} of messages
     */
    public Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName,
                                                      final List<String> columnList,
                                                      final Map<String, Object> conditionColumn) {
        return MESSAGE_SERVICE.getMessage(tableName, columnList, conditionColumn);
    }
}