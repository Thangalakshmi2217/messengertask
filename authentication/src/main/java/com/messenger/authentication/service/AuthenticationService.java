package com.messenger.authentication.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.messenger.orm.TableName;

/**
 * <p>
 *     An interface which provides {@link AuthenticationService}
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public interface AuthenticationService {

    /**
     * <p>
     *     Gets the particular user details.
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param columnList      represents the {@link List} of columns
     * @param conditionColumn gets the value by giving a certain condition
     * @return the {@link Collection} of user details
     */
    Collection<Map<String, Object>> getParticularDetailsById(final Enum<TableName> tableName,
                                                             final List<String> columnList,
                                                             final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Gets all the user details.
     * </p>
     *
     * @param tableName  represents the name of the table
     * @param columnList represents the {@link List} of columns
     * @return the {@link Collection} of user details
     */
    Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName, final List<String> columnList);

    /**
     * <p>
     *     Checks whether new user has been inserted.
     * </p>
     *
     * @param tableName     represents the name of the table
     * @param objectDetails represents user details
     * @return the User information inserted status
     */
    String addNewUser(final Enum<TableName> tableName, final Map<String, Object> objectDetails);

    /**
     * <p>
     *     Checks whether the username has been updated.
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param objectDetails   represents user details
     * @param conditionColumn gets the value by giving a certain condition
     * @return the username updated status
     */
    String updateUserName(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                          final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Checks whether the password has been updated.
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param objectDetails   represents user details
     * @param conditionColumn gets the value by giving a certain condition
     * @return the password updated status
     */
    String updatePassword(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                          final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Checks whether the particular details can be removed
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param conditionColumn gets the value by giving a certain condition
     * @return the deletion status
     */
    String deleteDetailsById(final Enum<TableName> tableName, final Map<String, Object> conditionColumn);
}