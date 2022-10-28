package com.messenger.authentication.view;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import com.messenger.orm.TableName;
import com.messenger.orm.UserLogin;
import com.messenger.validation.UserDetailValidation;
import com.messenger.authentication.model.UserDetail;
import com.messenger.authentication.controller.AuthenticationController;
import com.messenger.exception.UserNotFoundException;
import com.messenger.exception.UsernameAlreadyExistsException;
import com.messenger.validation.AuthenticationGroup.Delete;
import com.messenger.validation.AuthenticationGroup.Select;
import com.messenger.validation.AuthenticationGroup.Insert;
import com.messenger.validation.AuthenticationGroup.Update;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 *      Gets the user information through API and authenticates the user details.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
@Path("/")
public class AuthenticationView {

    private static final AuthenticationController AUTHENTICATION_CONTROLLER = new AuthenticationController();

    /**
     * <p>
     *     Retrieves particular details using the id.
     * </p>
     *
     * @param id refers the user's id
     * @return the {@link JSONObject} which contains the particular details
     */
    @Path("/userProfile/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public JSONObject getParticularDetails(@PathParam("id") final long id) {
        final Map<String, Object> result = new HashMap<>();
        final List<String> columnList = new ArrayList<>();
        final Map<String, Object> conditionColumnMap = new HashMap<>();
        final UserDetail userDetail = new UserDetail();

        userDetail.setUserId(id);
        final String validationResult = UserDetailValidation.validateDetails(userDetail, Select.class);

        columnList.add(UserLogin.userId.getColumnName());
        columnList.add(UserLogin.userName.getColumnName());
        conditionColumnMap.put(UserLogin.userId.getColumnName(), userDetail.getUserId());

        try {

            if (validationResult.equals("valid")) {
                result.put("result", AUTHENTICATION_CONTROLLER.getParticularDetailsById(TableName.user_login,
                        columnList, conditionColumnMap));
            } else {
                result.put("result", validationResult);
            }
        } catch (UserNotFoundException exception) {
            result.put("result", "user Not found");
        }

        return new JSONObject(result);
    }

    /**
     * <p>
     *     Fetches all the details.
     * </p>
     *
     * @return the {@link JSONObject} which contains all the details
     */
    @Path("/allUserDetails")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public JSONObject getAllDetails() {
        final Map<String, Object> result = new HashMap<>();
        final List<String> columnList = new ArrayList<>();

        columnList.add(UserLogin.userId.getColumnName());
        columnList.add(UserLogin.userName.getColumnName());
        result.put("status", AUTHENTICATION_CONTROLLER.getAllDetails(TableName.user_login, columnList));

        return new JSONObject(result);
    }

    /**
     * <p>
     *     Creates the user details.
     * </p>
     *
     * @param userDetail represents the {@link UserDetail}
     * @return the {@link JSONObject} which contains the generated status
     */
    @Path("/addNewUser")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public JSONObject addUser(final UserDetail userDetail) {
        final String validationMessage = UserDetailValidation.validateDetails(userDetail, Insert.class);
        final Map<String, Object> objectDetails = new HashMap<>();
        final Map<String, Object> result = new HashMap<>();

        objectDetails.put(UserLogin.userName.getColumnName(), userDetail.getUserName());
        objectDetails.put(UserLogin.password.getColumnName(), userDetail.getPassword());

        try {

            if (validationMessage.equals("valid")) {
                result.put("status", AUTHENTICATION_CONTROLLER.addNewUser(TableName.user_login, objectDetails));
            } else {
                result.put("status", validationMessage);
            }
        } catch (UsernameAlreadyExistsException exception) {
            result.put("status", "userName already Exists");
        }

        return new JSONObject(result);
    }

    /**
     * <p>
     *     Updates the password.
     * </p>
     *
     * @param userDetail represents the {@link UserDetail}
     * @return the {@link JSONObject} which contains the updated status
     */
    @Path("/updatePassword")
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public JSONObject changePassword(final UserDetail userDetail) {
        final String validationMessage = UserDetailValidation.validateDetails(userDetail, Update.class);
        final Map<String, Object> result = new HashMap<>();
        final Map<String, Object> conditionColumn = new HashMap<>();
        final Map<String, Object> objectMap = new HashMap<>();

        objectMap.put(UserLogin.password.getColumnName(), userDetail.getPassword());
        conditionColumn.put(UserLogin.userId.getColumnName(), userDetail.getUserId());

        try {

            if (validationMessage.equals("valid")) {
                result.put("status", AUTHENTICATION_CONTROLLER.updatePassword(TableName.user_login,
                        objectMap, conditionColumn));
            } else {
                result.put("status", validationMessage);
            }
        } catch (UserNotFoundException exception) {
            result.put("status", "user not found");
        }

        return new JSONObject(result);
    }

    /**
     * <p>
     *     Updates the username.
     * </p>
     *
     * @param userDetail represents the {@link UserDetail}
     * @return the {@link JSONObject} which contains the updated status
     */
    @Path("/updateUserName")
    @Produces(MediaType.APPLICATION_JSON)
    @PUT
    public JSONObject changeUserName(final UserDetail userDetail) {
        final String validationMessage = UserDetailValidation.validateDetails(userDetail, Update.class);
        final Map<String, Object> result = new HashMap<>();
        final Map<String, Object> conditionColumn = new HashMap<>();
        final Map<String, Object> objectDetails = new HashMap<>();

        objectDetails.put(UserLogin.userName.getColumnName(), userDetail.getUserName());
        conditionColumn.put(UserLogin.userId.getColumnName(), userDetail.getUserId());

        try {

            if (validationMessage.equals("valid")) {
                result.put("status", AUTHENTICATION_CONTROLLER.updateUserName(TableName.user_login, objectDetails,
                        conditionColumn));
            } else {
                result.put("status", validationMessage);
            }
        } catch (UserNotFoundException exception) {
            result.put("status", "user Not found");
        }

        return new JSONObject(result);
    }

    /**
     * <p>
     *     Deletes the specific details.
     * </p>
     *
     * @param id refers the user's id
     * @return the {@link JSONObject} which contains the deleted status
     */
    @Path("/deleteUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public JSONObject deleteDetails(@PathParam("id") final long id) {
        final Map<String, Object> result = new HashMap<>();
        final UserDetail userDetail = new UserDetail();
        final Map<String, Object> objectDetails = new HashMap<>();

        userDetail.setUserId(id);
        objectDetails.put(UserLogin.userId.getColumnName(), userDetail.getUserId());
        final String validationResult = UserDetailValidation.validateDetails(userDetail, Delete.class);

        try {

            if (validationResult.equals("valid")) {
                result.put("result", AUTHENTICATION_CONTROLLER.deleteDetailsById(TableName.user_login,
                        objectDetails));
            } else {
                result.put("result", validationResult);
            }
        } catch (UserNotFoundException exception) {
            result.put("result", "user Not Found");
        }

        return new JSONObject(result);
    }
}