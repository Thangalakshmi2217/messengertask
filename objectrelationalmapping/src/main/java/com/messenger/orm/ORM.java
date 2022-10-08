package com.messenger.orm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     An interface which provides {@link ORM} services.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public interface ORM {

    /**
     * <p>
     *     Checks whether the details are inserted.
     * </p>
     *
     * @param tableName    represents the name of the table
     * @param objectValues represents the column names and its value
     * @return true when the UserDetails is inserted
     */
    Boolean insert(final Enum<TableName> tableName, final Map<String, Object> objectValues);

    /**
     * <p>
     *     Gets the particular details.
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param columnList      represents the {@link List} of columns
     * @param conditionColumn getting a value from a column by specifying a condition
     * @return the {@link Collection} of details
     */
    Collection<Map<String, Object>> getParticularDetailsById(final Enum<TableName> tableName,
                                                             final List<String> columnList,
                                                             final Map<String, Object> conditionColumn);

    /**
     * <p>
     *     Collects the list of all the details.
     * </p>
     *
     * @param tableName  represents the name of the table
     * @param columnList {@link List} of columns
     * @return the {@link Collection} of details
     */
    Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName, final List<String> columnList);

    /**
     * <p>
     *     Checks whether the Details are updated.
     * </p>
     *
     * @param tableName       represents the name of the table
     * @param objectValues    represents the column names and its value
     * @param conditionColumn getting a value from a column by specifying a condition
     * @return true when the user details is updated
     */
    Boolean update(final Enum<TableName> tableName, final Map<String, Object> objectValues,
                   final Map<String, Object> conditionColumn);

    /**
     * <p>
     *    Checks whether the Details are removed.
     * </p>
     *
     * @param tableName    represents the name of the table
     * @param objectValues represents the column names and it's value
     * @return true when the user details is removed
     */
    Boolean delete(final Enum<TableName> tableName, final Map<String, Object> objectValues);
}