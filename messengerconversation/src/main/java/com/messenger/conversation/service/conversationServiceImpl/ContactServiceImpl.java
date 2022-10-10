package com.messenger.conversation.service.conversationServiceImpl;

import com.messenger.conversation.dao.ContactDAO;
import com.messenger.conversation.service.conversationService.ContactService;
import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Implements the {@link ContactService}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class ContactServiceImpl implements ContactService {

    private static final ContactDAO CONTACT_DAO = new ContactDAO();

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents name of the table
     * @param columnList      represents the {@link List} of columns
     * @param conditionColumn gets the value by giving a certain condition
     * @return the {@link Collection} of user contact details
     */
    @Override
    public Collection<Map<String, Object>> getUserContact(final Enum<TableName> tableName,
                                                          final List<String> columnList,
                                                          final Map<String, Object> conditionColumn) {
        return CONTACT_DAO.getUserContact(tableName, columnList, conditionColumn);
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return the contact insertion status
     */
    @Override
    public String addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return CONTACT_DAO.addNewContact(tableName, objectDetails) ? "Successfully Inserted " : "Invalid Details";
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents name of the table
     * @param objectDetails   represents the contact details
     * @param conditionColumn gets the value by giving a certain condition
     * @return the mobile number updated status
     */
    @Override
    public String updateMobileNumber(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                     final Map<String, Object> conditionColumn) {
        return CONTACT_DAO.updateMobileNumber(tableName, objectDetails, conditionColumn) ? "Successfully Updated"
                : "Invalid Details";
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the contact details
     * @return the contact deletion status
     */
    @Override
    public String deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return CONTACT_DAO.deleteUserContact(tableName, objectDetails) ? "Successfully Deleted" : "Invalid Details";
    }
}