package com.messenger.conversation.service.conversationServiceImpl;

import com.messenger.conversation.dao.MessageDAO;
import com.messenger.conversation.service.conversationService.MessageService;
import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *    Implemented the provided {@link MessageService}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class MessageServiceImpl implements MessageService {

    private static final MessageDAO MESSAGE_DAO = new MessageDAO();

    /**
     * {@inheritDoc}
     *
     * @param tableName     represents name of the table
     * @param objectDetails represents the message details
     * @return the message inserted status
     */
    public String addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return MESSAGE_DAO.addMessage(tableName, objectDetails) ? "successful inserted" : "Invalid Details";
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents name of the table
     * @param columnList      represents the {@link List} of columns
     * @param conditionColumn getting a value from a column by specifying a condition
     * @return the {@link Collection} of message details
     */
    public Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName, final List<String> columnList,
                                                      final Map<String, Object> conditionColumn) {
        return MESSAGE_DAO.getMessage(tableName, columnList, conditionColumn);
    }
}