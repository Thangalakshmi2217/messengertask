package com.messenger.authentication.dao;

import com.messenger.orm.ORMImpl;
import com.messenger.orm.TableName;

import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
import java.util.List;

/**
 * <p>
 *     Establishes the {@link Connection} to the database.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class AuthenticationDAO {

    private final static ORMImpl ORM_IMPL = ORMImpl.getInstance();

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
        return ORM_IMPL.getParticularDetailsById(tableName, columnList, conditionColumn);
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
        return ORM_IMPL.getAllDetails(tableName, columnList);
    }

    /**
     * <p>
     *     Checks whether user details have been created.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the user details
     * @return true when new user details are generated
     */
    public Boolean addNewUser(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return ORM_IMPL.insert(tableName, objectDetails);
    }

    /**
     * <p>
     *     Checks whether the password has been updated.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents user details
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return true when user password is updated
     */
    public Boolean updatePassword(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                  final Map<String, Object> conditionColumn) {
        return ORM_IMPL.update(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Checks whether the username has been updated.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents user details
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return true when username is updated
     */
    public Boolean updateUserName(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                  final Map<String, Object> conditionColumn) {
        return ORM_IMPL.update(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Checks whether details have been deleted using the id.
     * </p>
     *
     * @param tableName       represents the table name
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return true when user details are deleted
     */
    public Boolean deleteDetailsById(final Enum<TableName> tableName, final Map<String, Object> conditionColumn) {
        return ORM_IMPL.delete(tableName, conditionColumn);
    }
}