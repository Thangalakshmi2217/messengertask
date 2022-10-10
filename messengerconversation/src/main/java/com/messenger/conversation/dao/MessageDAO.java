package com.messenger.conversation.dao;

import com.messenger.orm.ORMImpl;
import com.messenger.orm.TableName;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Establishes the {@link Connection} to the database and executes the CRUD operation.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class MessageDAO {

    private static final ORMImpl ORM_IMPL = ORMImpl.getInstance();

    /**
     * <p>
     *     Inserted a new message.
     * </P>
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the message details
     * @return true when the message is inserted
     */
    public Boolean addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return ORM_IMPL.insert(tableName, objectDetails);
    }

    /**
     * <p>
     *     Get the message.
     * </p>
     *
     * @param tableName       represents name of the table
     * @param columnList      represents the {@link List} of column
     * @param conditionColumn obtaining a value from the column by stating the condition
     * @return the {@link Collection} of messages
     */
    public Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName, final List<String> columnList,
                                                      final Map<String, Object> conditionColumn) {
        return ORM_IMPL.getParticularDetailsById(tableName, columnList, conditionColumn);
    }
}