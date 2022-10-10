package com.messenger.authentication.dao;

import com.messenger.orm.ORMImpl;
import com.messenger.orm.TableName;

import java.sql.Connection;
import java.util.Collection;
import java.util.Map;
import java.util.List;

/**
 * <p>
 *     Establishes the {@link Connection} to the database and executes the CRUD operation.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class AuthenticationDAO {

    private final static ORMImpl ORM_IMPL = ORMImpl.getInstance();

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
    public Collection<Map<String, Object>> getParticularDetailsById(final Enum<TableName> tableName,
                                                                    final List<String> columnList,
                                                                    final Map<String, Object> conditionColumn) {
        return ORM_IMPL.getParticularDetailsById(tableName, columnList, conditionColumn);
    }

    /**
     * <p>
     *     Gets all the user details.
     * </p>
     *
     * @param tableName  represents the name of the table
     * @param columnList represents the {@link List} of columns
     * @return the {@link Collection} of user details
     */
    public Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName,
                                                         final List<String> columnList) {
        return ORM_IMPL.getAllDetails(tableName, columnList);
    }

    /**
     * <p>
     *     Inserted a new user.
     * </p>
     *
     * @param tableName     represents the name of the table
     * @param objectDetails represents the user details
     * @return true when the new user details is inserted
     */
    public Boolean addNewUser(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return ORM_IMPL.insert(tableName, objectDetails);
    }

    /**
     * <p>
     *     Updated the user password.
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param objectDetails   represents user details
     * @param conditionColumn gets the value by giving a certain condition
     * @return true when the user password is updated
     */
    public Boolean updatePassword(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                  final Map<String, Object> conditionColumn) {
        return ORM_IMPL.update(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Updated the username.
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param objectDetails   represents user details
     * @param conditionColumn obtaining a value from the column by stating the condition
     * @return true when the username is updated
     */
    public Boolean updateUserName(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                                  final Map<String, Object> conditionColumn) {
        return ORM_IMPL.update(tableName, objectDetails, conditionColumn);
    }

    /**
     * <p>
     *     Removed the specific user details.
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param conditionColumn gets the value by giving a certain condition
     * @return true when the user details is removed
     */
    public Boolean deleteDetailsById(final Enum<TableName> tableName, final Map<String, Object> conditionColumn) {
        return ORM_IMPL.delete(tableName, conditionColumn);
    }
}