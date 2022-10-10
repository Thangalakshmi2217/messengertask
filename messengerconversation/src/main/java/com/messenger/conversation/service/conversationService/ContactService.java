package com.messenger.conversation.service.conversationService;

import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     An interface which provides {@link ContactService}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public interface ContactService {

    /**
     * <p>
     *     Gets the user contact.
     * </p>
     *
     * @param tableName           represents name of the table
     * @param columnList          represents the {@link List} of columns
     * @param conditionColumn     gets the value by giving a certain condition
     * @return the {@link Collection} of user contact details
     */
    Collection<Map<String, Object>> getUserContact(final Enum<TableName> tableName,
                                                   final List<String> columnList,
                                                   final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Checks whether user contact has been inserted.
     * </p>
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return the contact insertion status
     */
    String addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails);

    /**
     * <p>
     *     Checks whether the mobile number has been updated.
     * </p>
     *
     * @param tableName       represents name of the table
     * @param objectDetails   represents contact details
     * @param conditionColumn gets the value by giving a certain condition
     * @return the mobile number updated status
     */
    String updateMobileNumber(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                              final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Checks whether user contact details are removed.
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return the contact deletion status
     */
    String deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails);
}