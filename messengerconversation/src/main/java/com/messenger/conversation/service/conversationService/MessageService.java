package com.messenger.conversation.service.conversationService;

import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     Provides {@link MessageService}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public interface MessageService {

    /**
     * <p>
     *    Creates a message.
     * </p>
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the message details
     * @return the generated status
     */
    String addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails);

    /**
     * <p>
     *     Fetches the message.
     * </p>
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the {@link Collection} which contains the message
     */
    Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName, final List<String> columnList,
                                               final Map<String, Object> conditionColumn);
}