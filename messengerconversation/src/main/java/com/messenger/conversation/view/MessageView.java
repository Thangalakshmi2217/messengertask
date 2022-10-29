package com.messenger.conversation.view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;

import com.messenger.conversation.controller.ConversationController;
import com.messenger.conversation.model.ConversationDetail;
import com.messenger.orm.Message;
import com.messenger.orm.TableName;
import com.messenger.validation.ConversationGroup.Select;
import com.messenger.validation.ConversationGroup.Send;
import com.messenger.validation.UserDetailValidation;

import org.json.simple.JSONObject;

/**
 * <p>
 *      Sends the message through {@code API} and gets the message history.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class MessageView extends ConversationController {

    private final static ConversationController CONVERSATION_CONTROLLER = new ConversationController();

    /**
     * <p>
     *     Creates a new message.
     * </p>
     *
     * @param conversationDetail represents the {@link ConversationDetail} which contains details relating to the
     *                           conversation
     * @return the {@link JSONObject} which contains message status
     */
    @Path("/sendMessage")
    @Produces("application/json")
    @POST
    public JSONObject sendMessage(final ConversationDetail conversationDetail) {
        final Date date = new Date();
        final long time = date.getTime();
        final Timestamp messageTimestamp = new Timestamp(time);
        final String validationMessage = UserDetailValidation.validateDetails(conversationDetail, Send.class);
        final Map<String, Object> userInformation = new HashMap<>();
        final Map<String, Object> result = new HashMap<>();

        conversationDetail.setMessageTime(messageTimestamp);
        userInformation.put(Message.profileId.getColumnName(), conversationDetail.getProfileId());
        userInformation.put(Message.contactId.getColumnName(), conversationDetail.getContactId());
        userInformation.put(Message.messageTime.getColumnName(), conversationDetail.getMessageTime());
        userInformation.put(Message.messageDetails.getColumnName(), conversationDetail.getMessageContent());

        if (validationMessage.equals("valid")) {
            result.put("status", CONVERSATION_CONTROLLER.addMessage(TableName.user_message, userInformation));
        } else {
            result.put("status", validationMessage);
        }

        return new JSONObject(result);
    }

    /**
     * <p>
     *     Gets the message history.
     * </p>
     *
     * @param id refers the user's id
     * @return the {@link JSONObject} which contains the message history
     */
    @Path("/messageHistory/{id}")
    @Produces("application/json")
    @GET
    public JSONObject getMessageHistory(final @PathParam("id") long id) {
        final Map<String, Object> result = new HashMap<>();
        final List<String> columnList = new ArrayList<>();
        final Map<String, Object> conditionColumnMap = new HashMap<>();
        final ConversationDetail conversationDetail = new ConversationDetail();

        conversationDetail.setProfileId(id);
        final String validationResult = UserDetailValidation.validateDetails(conversationDetail, Select.class);

        columnList.add(Message.contactId.getColumnName());
        columnList.add(Message.messageTime.getColumnName());
        columnList.add(Message.messageDetails.getColumnName());
        conditionColumnMap.put(Message.profileId.getColumnName(), conversationDetail.getProfileId());

        if (validationResult.equals("valid")) {
            result.put("result", CONVERSATION_CONTROLLER.getMessage(TableName.user_message, columnList,
                    conditionColumnMap).toString());
        } else {
            result.put("result", validationResult);
        }

        return new JSONObject(result);
    }
}