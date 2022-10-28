package com.messenger.authentication.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.messenger.authentication.service.AuthenticationServiceImpl;
import com.messenger.orm.TableName;

/**
 * <p>
 *     Controls all user requests and the responses.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class AuthenticationController {

    private static final AuthenticationServiceImpl AUTHENTICATION_SERVICE = new AuthenticationServiceImpl();

    /**
     * <p>
     *     Retrieves particular details using the id.
     * </p>
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return the particular details
     */
    public Collection<Map<String, Object>> getParticularDetailsById(final Enum<TableName> tableName,
                                                                    final List<String> columnList,
                                                                    final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_SERVICE.getParticularDetailsById(tableName, columnList, conditionColumn);
    }

    /**
     * <p>
     *     Fetches all the details.
     * </p>
     *
     * @param tableName  represents the table name
     * @param columnList represents the name of table's column
     * @return the {@link Collection} which contains all the details
     */
    public Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName,
                                                         final List<String> columnList) {
        return AUTHENTICATION_SERVICE.getAllDetails(tableName, columnList);
    }

    /**
     * <p>
     *     Creates new user details.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the user details
     * @return the generated status
     */
    public String addNewUser(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return AUTHENTICATION_SERVICE.addNewUser(tableName, objectDetails);
    }

    /**
     * <p>
     *     Updates the password.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents the user details
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return the updated status
     */
    public String updatePassword(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                 final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_SERVICE.updatePassword(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Updates the username.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents the user details
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return the updated status
     */
    public String updateUserName(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                 final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_SERVICE.updateUserName(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Deletes details using the id.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the user details
     * @return the deleted status
     */
    public String deleteDetailsById(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return AUTHENTICATION_SERVICE.deleteDetailsById(tableName, objectDetails);
    }
}