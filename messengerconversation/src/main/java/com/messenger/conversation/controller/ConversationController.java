package com.messenger.conversation.controller;

import com.messenger.conversation.service.conversationServiceImpl.ContactServiceImpl;
import com.messenger.conversation.service.conversationServiceImpl.MessageServiceImpl;
import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Handles all the requests from the API and manages to send back the response to the user.
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
     *     Gets the user contacts.
     * </p>
     *
     * @param tableName           represents name of the table
     * @param columnList          represents the {@link List} of columns
     * @param conditionColumn     gets the value by giving a certain condition
     * @return the {@link Collection} of contact details
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
     * @return the message new contact is inserted
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
     * @param conditionColumn gets the value by giving a certain condition
     * @return the message mobile number updated
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
     * @return the message user contact is deleted
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
     * @return the message, a new message is inserted
     */
    public String addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return MESSAGE_SERVICE.addMessage(tableName, objectDetails);
    }

    /**
     * <p>
     *     Gets the message.
     * </p>
     *
     * @param tableName       represent name of the table
     * @param columnList      represents the {@link List} of columns
     * @param conditionColumn gets the value by giving a certain condition
     * @return the {@link Collection} of message
     */
    public Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName,
                                                      final List<String> columnList,
                                                      final Map<String, Object> conditionColumn) {
        return MESSAGE_SERVICE.getMessage(tableName, columnList, conditionColumn);
    }
}