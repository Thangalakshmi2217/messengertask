package com.messenger.conversation.service.conversationService;

import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *     An interface which provides {@link MessageService}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public interface MessageService {

    /**
     * <p>
     *    Checks whether the New Message has been inserted.
     * </p>
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the message details
     * @return the user message inserted status
     */
    String addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails);

    /**
     * <p>
     *     Gets the message.
     * </p>
     *
     * @param tableName       represents name of the table
     * @param columnList      represents the {@link List} of columns
     * @param conditionColumn gets the value by giving a certain condition
     * @return the {@link Collection} of message details
     */
    Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName, final List<String> columnList,
                                               final Map<String, Object> conditionColumn);
}