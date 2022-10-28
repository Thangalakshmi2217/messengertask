package com.messenger.authentication.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.messenger.authentication.dao.AuthenticationDAO;
import com.messenger.orm.TableName;

/**
 * <p>
 *     Implements the {@link AuthenticationService}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final AuthenticationDAO AUTHENTICATION_DAO = new AuthenticationDAO();

    /**
     * {@inheritDoc}
     *
     * @param tableName        represents the table name
     * @param columnList       represents the name of table's column
     * @param conditionColumn  retrieves the value from the field based on the specific condition 
     * @return the particular details
     */
    public Collection<Map<String, Object>> getParticularDetailsById(final Enum<TableName> tableName,
                                                                    final List<String> columnList,
                                                                    final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_DAO.getParticularDetailsById(tableName, columnList, conditionColumn);
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName  represents the table name
     * @param columnList represents the name of table's column
     * @return the {@link Collection} of details
     */
    @Override
    public Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName,
                                                         final List<String> columnList) {
        return AUTHENTICATION_DAO.getAllDetails(tableName, columnList);
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName     represents the table name
     * @param objectDetails represents user details
     * @return the generated status
     */
    @Override
    public String addNewUser(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return AUTHENTICATION_DAO.addNewUser(tableName, objectDetails) ? "Successfully Inserted" : "Invalid Details";
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents user details
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the updated status
     */
    @Override
    public String updateUserName(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                 final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_DAO.updateUserName(tableName, objectDetails, conditionColumn) ? "Successfully Updated"
                : "Invalid Details";
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents user details
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the updated status
     */
    public String updatePassword(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                 final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_DAO.updatePassword(tableName, objectDetails, conditionColumn) ? "Successfully Updated"
                : "Invalid Details";
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents the table name
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the deleted status
     */
    @Override
    public String deleteDetailsById(final Enum<TableName> tableName, final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_DAO.deleteDetailsById(tableName, conditionColumn) ? "Successfully Deleted"
                : "Invalid Details";
    }
}