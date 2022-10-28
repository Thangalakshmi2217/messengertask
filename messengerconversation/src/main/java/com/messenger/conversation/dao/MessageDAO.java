package com.messenger.conversation.dao;

import com.messenger.orm.ORMImpl;
import com.messenger.orm.TableName;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Establishes the {@link Connection} to the database.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class MessageDAO {

    private static final ORMImpl ORM_IMPL = ORMImpl.getInstance();

    /**
     * <p>
     *     Checks whether new message has been generated.
     * </P>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the message details
     * @return true when the message is generated
     */
    public Boolean addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return ORM_IMPL.insert(tableName, objectDetails);
    }

    /**
     * <p>
     *     Fetches the message.
     * </p>
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition
     * @return the {@link Collection} which contains the messages
     */
    public Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName, final List<String> columnList,
                                                      final Map<String, Object> conditionColumn) {
        return ORM_IMPL.getParticularDetailsById(tableName, columnList, conditionColumn);
    }
}