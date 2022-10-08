package com.messenger.authentication.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.messenger.authentication.service.AuthenticationServiceImpl;
import com.messenger.orm.TableName;

/**
 * <p>
 *    Controls all the requests from the API.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class AuthenticationController {

    private static final AuthenticationServiceImpl AUTHENTICATION_SERVICE = new AuthenticationServiceImpl();

    /**
     * <p>
     *     Gets the particular user details.
     * </p>
     *
     * @param tableName       represents the name of a table
     * @param columnList      represents the {@link List} of columns
     * @param conditionColumn getting a value from a column by specifying a condition
     * @return the {@link Collection} of user details
     */
    public Collection<Map<String, Object>> getParticularDetailsById(final Enum<TableName> tableName,
                                                                    final List<String> columnList,
                                                                    final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_SERVICE.getParticularDetailsById(tableName, columnList, conditionColumn);
    }

    /**
     * <p>
     *     Collects all the user details.
     * </p>
     *
     * @param tableName  represents the name of a table
     * @param columnList represents the {@link List} of columns
     * @return the {@link Collection} of all user details
     */
    public Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName,
                                                         final List<String> columnList) {
        return AUTHENTICATION_SERVICE.getAllDetails(tableName, columnList);
    }

    /**
     * <p>
     *     Checks whether the user details are inserted.
     * </p>
     *
     * @param tableName     represents the name of a table
     * @param objectDetails represents the user details
     * @return the inserted user details
     */
    public String addNewUser(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return AUTHENTICATION_SERVICE.addNewUser(tableName, objectDetails);
    }

    /**
     * <p>
     *     Checks whether the password has been updated.
     * </p>
     *
     * @param tableName       represents the name of a table
     * @param objectDetails   represents the user details
     * @param conditionColumn obtaining a value from the column by stating the condition
     * @return the password updated in the specific column
     */
    public String updatePassword(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                 final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_SERVICE.updatePassword(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Checks whether the Username has been updated.
     * </p>
     *
     * @param tableName       represents the name of a table
     * @param objectDetails   represents the user details
     * @param conditionColumn getting a value from a column by specifying a condition
     * @return the username updated in the specific column
     */
    public String updateUserName(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                 final Map<String, Object> conditionColumn) {
        return AUTHENTICATION_SERVICE.updateUserName(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Checks whether the user details has been deleted.
     * </p>
     *
     * @param tableName     represents the name of a table
     * @param objectDetails represents the user details
     * @return the particular deleted details
     */
    public String deleteDetailsById(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return AUTHENTICATION_SERVICE.deleteDetailsById(tableName, objectDetails);
    }
}