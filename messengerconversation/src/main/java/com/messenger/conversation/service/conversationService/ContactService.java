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
     *     Checks whether specific UserContact can be retrieved.
     * </p>
     *
     * @param tableName           represents name of the table
     * @param columnList          represents the {@link List} of columns
     * @param conditionColumn     getting a value from a column by specifying a condition
     * @return the {@link Collection} of user contact details
     */
    Collection<Map<String, Object>> getUserContact(final Enum<TableName> tableName,
                                                   final List<String> columnList,
                                                   final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Checks whether UserContact has been inserted.
     * </p>
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return the new contact inserted status
     */
    String addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails);

    /**
     * <p>
     *     Checks whether the MobileNumber has been updated.
     * </p>
     *
     * @param tableName       represents name of the table
     * @param objectDetails   represents contact details
     * @param conditionColumn getting a value from a column by specifying a condition
     * @return the mobile number updated status
     */
    String updateMobileNumber(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                              final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Checks whether UserContact details are removed.
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return the contact deletion status
     */
    String deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails);
}