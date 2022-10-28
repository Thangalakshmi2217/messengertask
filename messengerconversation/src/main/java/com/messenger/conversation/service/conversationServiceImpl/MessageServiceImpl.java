package com.messenger.conversation.service.conversationServiceImpl;

import com.messenger.conversation.dao.MessageDAO;
import com.messenger.conversation.service.conversationService.MessageService;
import com.messenger.orm.TableName;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *    Implements the {@link MessageService}.
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
     * @param tableName     represents the table name
     * @param objectDetails represents the message details
     * @return the generated status
     */
    public String addMessage(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        return MESSAGE_DAO.addMessage(tableName, objectDetails) ? "successful inserted" : "Invalid Details";
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the {@link Collection} which contains the message
     */
    public Collection<Map<String, Object>> getMessage(final Enum<TableName> tableName, final List<String> columnList,
                                                      final Map<String, Object> conditionColumn) {
        return MESSAGE_DAO.getMessage(tableName, columnList, conditionColumn);
    }
}