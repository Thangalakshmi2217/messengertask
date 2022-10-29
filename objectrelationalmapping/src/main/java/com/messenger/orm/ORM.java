package com.messenger.orm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Provides the orm services.
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
     * @param tableName    represents the table name
     * @param objectValues represents the column names and its value
     * @return true when detail is generated
     */
    Boolean insert(final Enum<TableName> tableName, final Map<String, Object> objectValues);

    /**
     * <p>
     *     Retrieves the particular details.
     * </p>
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the {@link Collection} which contains the particular detail
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
     * @param columnList {@link List} of columns
     * @return the {@link Collection} which contains all the details
     */
    Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName, final List<String> columnList);

    /**
     * <p>
     *     Checks whether details are updated.
     * </p>
     *
     * @param tableName       represents the table name
     * @param objectValues    represents the column names and its value
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return true when user detail is updated
     */
    Boolean update(final Enum<TableName> tableName, final Map<String, Object> objectValues,
                   final Map<String, Object> conditionColumn);

    /**
     * <p>
     *    Checks whether details are deleted.
     * </p>
     *
     * @param tableName    represents the table name
     * @param objectValues represents the column names and it's value
     * @return true when detail is deleted
     */
    Boolean delete(final Enum<TableName> tableName, final Map<String, Object> objectValues);
}