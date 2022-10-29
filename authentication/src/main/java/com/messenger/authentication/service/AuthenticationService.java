package com.messenger.authentication.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.messenger.orm.TableName;

/**
 * <p>
 *     Provides the authentication service.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public interface AuthenticationService {

    /**
     * <p>
     *     Retrieves particular details using the id.
     * </p>
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the {@link Collection} which contains particular details
     */
    Collection<Map<String, Object>> getParticularDetailsById(final Enum<TableName> tableName,
                                                             final List<String> columnList,
                                                             final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Fetches all the details.
     * </p>
     *
     * @param tableName  represents the table name
     * @param columnList represents the name of table's column
     * @return the {@link Collection} which contains all the details
     */
    Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName, final List<String> columnList);

    /**
     * <p>
     *     Creates new user details.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents user details
     * @return the generated status
     */
    String addNewUser(final Enum<TableName> tableName, final Map<String, Object> objectDetails);

    /**
     * <p>
     *     Updates an existing username.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents user details
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the updated status
     */
    String updateUserName(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                          final Map<String, Object> conditionColumn);

    /**
     * <p>
     *    Updates an existing password.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents user details
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the updated status
     */
    String updatePassword(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                          final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Deletes details using the id.
     * </p>
     *
     * @param tableName       represents the table name
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return the deleted status
     */
    String deleteDetailsById(final Enum<TableName> tableName, final Map<String, Object> conditionColumn);
}