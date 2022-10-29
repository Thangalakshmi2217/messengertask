package com.messenger.conversation.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.messenger.conversation.controller.ConversationController;
import com.messenger.conversation.model.ConversationDetail;
import com.messenger.orm.Contact;
import com.messenger.orm.TableName;
import com.messenger.validation.ConversationGroup.Delete;
import com.messenger.validation.ConversationGroup.Select;
import com.messenger.validation.ConversationGroup.Update;
import com.messenger.validation.ConversationGroup.Insert;
import com.messenger.validation.UserDetailValidation;

import org.json.simple.JSONObject;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * <p>
 *     Integrates and authorizes the contact information through <code>API</code>.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
@Path("/")
public class ContactView {

    private final static ConversationController CONVERSATION_CONTROLLER = new ConversationController();

    /**
     * <p>
     *     Gets the contact and limits the content of contact details.
     * </p>
     *
     * @param id     refers the user's id
     * @param start  refers the start value
     * @param limit  represents the number of details to be displayed
     * @return {@link JSONObject} which contains the contact details
     */
    @Path("/userContactDetails/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public JSONObject getContact(@QueryParam("id") final long id, @QueryParam("start") int start,
                                 @QueryParam("limit") final int limit) {
        final List<String> columnList = new ArrayList<>();
        final Map<String, String> error = new HashMap<>();
        final Map<String, String> result = new HashMap<>();
        final Map<String, List<Map<String, Object>>> contactDetails = new HashMap<>();
        final Map<String, Object> conditionColumnMap = new HashMap<>();
        final ConversationDetail conversationDetail = new ConversationDetail();

        conversationDetail.setProfileId(id);
        final String validationResult = UserDetailValidation.validateDetails(conversationDetail, Select.class);

        columnList.add(Contact.mobileNumber.getColumnName());
        columnList.add(Contact.personName.getColumnName());
        conditionColumnMap.put(Contact.profileId.getColumnName(), conversationDetail.getProfileId());

        if (validationResult.equals("valid")) {
            int end;

            if (start >= 0 & limit > 0) {
                end = limit * start;
            } else if (start <= 0) {
                final int defaultPageSize = 1;

                start = (1);
                end = limit * defaultPageSize;
            } else {
                final int defaultLimitSize = 3;

                start = ((start - 1) * defaultLimitSize);
                end = defaultLimitSize * start;
            }
            final List<Map<String, Object>> contactList = new ArrayList<>(CONVERSATION_CONTROLLER.getUserContact
                    (TableName.user_contact, columnList, conditionColumnMap));

            if (start < contactList.size() && end < contactList.size()) {
                contactDetails.put("result", contactList.subList(start, end));

                return new JSONObject(contactDetails);
            } else if (start < contactList.size()) {
                contactDetails.put("result", contactList.subList(start, contactList.size()));

                return new JSONObject(contactDetails);
            } else {
                error.put("result", "pages not found");

                return new JSONObject(error);
            }
        } else {
            result.put("result", validationResult);
        }

        return new JSONObject(result);
    }

    /**
     * <p>
     *     Creates a new contact.
     * </p>
     *
     * @param conversationDetail represents the {@link ConversationDetail} which contains details relating to the
     *                           conversation
     * @return {@link JSONObject} which contains the generated status
     */
    @Path("/addContact")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public JSONObject addContact(final ConversationDetail conversationDetail) {
        final String validationMessage = UserDetailValidation.validateDetails(conversationDetail, Insert.class);
        final Map<String, Object> userInformation = new HashMap<>();
        final Map<String, Object> result = new HashMap<>();

        userInformation.put(Contact.profileId.getColumnName(), conversationDetail.getProfileId());
        userInformation.put(Contact.mobileNumber.getColumnName(), conversationDetail.getMobileNumber());
        userInformation.put(Contact.personName.getColumnName(), conversationDetail.getPersonName());

        if (validationMessage.equals("valid")) {
            result.put("status", CONVERSATION_CONTROLLER.addNewContact(TableName.user_contact, userInformation));
        } else {
            result.put("status", validationMessage);
        }

        return new JSONObject(result);
    }

    /**
     * <p>
     *    Updates the mobile number.
     * </p>
     *
     * @param conversationDetail represents the {@link ConversationDetail} which contains details relating to the
     *                           conversation
     * @return the {@link JSONObject} which contains the updated status
     */
    @Path("/changeMobileNumber")
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public JSONObject changeMobileNumber(final ConversationDetail conversationDetail) {
        final String validationMessage = UserDetailValidation.validateDetails(conversationDetail, Update.class);
        final Map<String, Object> result = new HashMap<>();
        final Map<String, Object> conditionColumn = new HashMap<>();
        final Map<String, Object> objectDetails = new HashMap<>();

        conditionColumn.put(Contact.contactId.getColumnName(), conversationDetail.getContactId());
        objectDetails.put(Contact.mobileNumber.getColumnName(), conversationDetail.getMobileNumber());

        if (validationMessage.equals("valid")) {
            result.put("status", CONVERSATION_CONTROLLER.updateMobileNumber(TableName.user_contact, objectDetails,
                    conditionColumn));
        } else {
            result.put("status", validationMessage);
        }

        return new JSONObject(result);
    }

    /**
     * <p>
     *     Deletes a specific contact using id.
     * </p>
     *
     * @param id refers to the user's id
     * @return the {@link JSONObject} which contains the deleted status
     */
    @Path("/deleteParticularContact/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public JSONObject deleteContact(final @QueryParam("id") long id) {
        final Map<String, Object> result = new HashMap<>();
        final Map<String, Object> objectDetails = new HashMap<>();
        final ConversationDetail conversationDetail = new ConversationDetail();

        conversationDetail.setContactId(id);
        objectDetails.put(Contact.contactId.getColumnName(), conversationDetail.getContactId());
        final String validationResult = UserDetailValidation.validateDetails(conversationDetail, Delete.class);

        if (validationResult.equals("valid")) {
            result.put("result", CONVERSATION_CONTROLLER.deleteUserContact(TableName.user_contact, objectDetails));
        } else {
            result.put("result", validationResult);
        }

        return new JSONObject(result);
    }
}