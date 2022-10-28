package com.messenger.conversation.controller;

import com.messenger.conversation.service.conversationServiceImpl.ContactServiceImpl;
import com.messenger.conversation.service.conversationServiceImpl.MessageServiceImpl;
import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Controls all the contact requests and the responses.
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
     *     Retrieves the user contact.
     * </p>
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return the particular user contact 
     */
    public Collection<Map<String, Object>> getUserContact(final Enum<TableName> tableName,
                                                          final List<String> columnList,
                                                          final Map<String, Object> conditionColumn) {
        return CONTACT_SERVICE.getUserContact(tableName, columnList, conditionColumn);
    }

    /**
     * <p>
     *     Creates new contact.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the contact details
     * @return the generated status
     */
    public String addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return CONTACT_SERVICE.addNewContact(tableName, objectDetails);
    }

    /**
     * <p>
     *     Updates mobile number.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents the contact details
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the updated status
     */
    public String updateMobileNumber(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                     final Map<String, Object> conditionColumn) {
        return CONTACT_SERVICE.updateMobileNumber(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Deletes the user contact.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the contact details
     * @return the deleted status
     */
    public String deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return CONTACT_SERVICE.deleteUserContact(tableName, objectDetails);
    }

    /**
     * <p>
     *     Creates a new message.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the message details
     * @return the generated status
     */
    public String addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return MESSAGE_SERVICE.addMessage(tableName, objectDetails);
    }

    /**
     * <p>
     *     Fetches the message.
     * </p>
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the {@link Collection} which contains message
     */
    public Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName,
                                                      final List<String> columnList,
                                                      final Map<String, Object> conditionColumn) {
        return MESSAGE_SERVICE.getMessage(tableName, columnList, conditionColumn);
    }
}