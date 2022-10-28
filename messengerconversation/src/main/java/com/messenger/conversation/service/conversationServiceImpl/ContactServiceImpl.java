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
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the particular user contact 
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
     * @param tableName     represents the table name
     * @param objectDetails represents the contact details
     * @return the generated status
     */
    @Override
    public String addNewContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return CONTACT_DAO.addNewContact(tableName, objectDetails) ? "Successfully Inserted " : "Invalid Details";
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents the contact details
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the updated status
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
     * @param tableName     represents the table name
     * @param objectDetails represents the contact details
     * @return the deleted status
     */
    @Override
    public String deleteUserContact(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return CONTACT_DAO.deleteUserContact(tableName, objectDetails) ? "Successfully Deleted" : "Invalid Details";
    }
}