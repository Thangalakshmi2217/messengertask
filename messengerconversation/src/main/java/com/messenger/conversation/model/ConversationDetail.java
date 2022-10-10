package com.messenger.conversation.model;

import com.messenger.validation.ConversationGroup.Name;
import com.messenger.validation.ConversationGroup.Send;
import com.messenger.validation.ConversationGroup.Delete;
import com.messenger.validation.ConversationGroup.Insert;
import com.messenger.validation.ConversationGroup.Update;
import com.messenger.validation.ConversationGroup.Select;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

//import javax.lang.model.element.Name;
import java.sql.Timestamp;

/**
 * <p>
 *     A model class which represents the {@link ConversationDetail}.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class ConversationDetail {

    @Positive(message = "contactId should not be empty or null", groups = {Update.class, Delete.class, Send.class})
    @Min(value = 1, message = "contactId should have at least 1 character", groups = {Update.class, Delete.class,
            Send.class})
    private long contactId;

    @Positive(message = "mobileNumber must contain positive number only", groups = {Insert.class, Update.class})
    private long mobileNumber;

    @PersonName(groups = Insert.class)
    private String personName;

    @Positive(message = "profileId should not be empty or null", groups = {Insert.class, Select.class, Send.class})
    @Min(value = 1, message = "profileId should have at least 1 character", groups = {Insert.class, Select.class,
            Select.class})
    private long profileId;
    private Timestamp messageTime;
    private String messageContent;
    private String profileName;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public Timestamp getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Timestamp messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

}