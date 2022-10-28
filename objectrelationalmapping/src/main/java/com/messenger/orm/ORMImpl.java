package com.messenger.orm;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/**
 * <p>
 *     Implements the {@link ORM} services.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class ORMImpl implements ORM {

    private static ORMImpl orm;

    private ORMImpl() {
    }

    /**
     * <p>
     *    Gets the ORM instance.
     * </p>
     *
     * @return {@link ORMImpl}
     */
    public static ORMImpl getInstance() {

        if (orm == null) {
            orm = new ORMImpl();
        }
        return orm;
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName    represents the table name
     * @param objectValues represents the column names and it's value
     * @return true when detail is generated
     */
    public Boolean insert(final Enum<TableName> tableName, final Map<String, Object> objectValues) {
        final StringJoiner column = new StringJoiner(",");
        final StringJoiner conditionColumnValues = new StringJoiner("' , '");
        final Collection<Object> valuesList = objectValues.values();
        final Set<String> columnList = objectValues.keySet();
        final StringBuilder insertQueryBuilder = new StringBuilder();

        for (final String name : columnList) {
            column.add(name);
        }

        for (final Object value : valuesList) {
            conditionColumnValues.add(value.toString());
        }
        insertQueryBuilder.append("insert into ").append(tableName).append("(").append(column).append(")")
                .append(" values ").append(" ('").append(conditionColumnValues).append("');");

        try (Statement statement = ConnectDataBase.getInstance().getConnection().createStatement()) {
            return statement.executeUpdate(String.valueOf(insertQueryBuilder)) > 0;
        } catch (Exception exception) {
            throw new UsernameAlreadyExistsException("userName Already Exists");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents the table name
     * @param columnList      represents the name of table's column
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return the particular detail
     */
    public Collection<Map<String, Object>> getParticularDetailsById(final Enum<TableName> tableName,
                                                                    final List<String> columnList,
                                                                    final Map<String, Object> conditionColumn) {
        final StringJoiner column = new StringJoiner(" , ");
        final StringJoiner conditionColumnValues = new StringJoiner(" , ");
        final StringBuilder selectParticularQueryBuilder = new StringBuilder();

        for (final String name : columnList) {
            column.add(name);
        }

        for (final Map.Entry<String, Object> fields : conditionColumn.entrySet()) {
            conditionColumnValues.add(fields.getKey() + " = " + fields.getValue());
        }
        selectParticularQueryBuilder.append(" Select ").append(column).append(" from ").append(tableName)
                .append(" where ").append(conditionColumnValues);

        return retrieveDetails(selectParticularQueryBuilder.toString());
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName  represents the table name
     * @param columnList represents the name of table's column
     * @return the {@link Collection} which contains all the details
     */
    public Collection<Map<String, Object>> getAllDetails(final Enum<TableName> tableName,
                                                         final List<String> columnList) {
        final StringJoiner column = new StringJoiner(",");
        final StringBuilder selectQueryBuilder = new StringBuilder();

        for (final String fields : columnList) {
            column.add(fields);
        }
        selectQueryBuilder.append(" Select ").append(column).append(" from ").append(tableName);

        return retrieveDetails(selectQueryBuilder.toString());
    }

    /**
     * <p>
     *     Retrieves the details.
     * </p>
     *
     * @param selectQuery  selects the data from a database.
     * @return the {@link Collection} which contains the details
     */
    private Collection<Map<String, Object>> retrieveDetails(final String selectQuery) {
        final List<Map<String, Object>> result = new ArrayList<>();

        try (Statement statement = ConnectDataBase.getInstance().getConnection().createStatement()) {
            final ResultSet resultSet = statement.executeQuery(String.valueOf(selectQuery));
            final ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while (resultSet.next()) {
                final Map<String, Object> userDetails = new HashMap<>();

                for (int columnId = 1; columnId <= resultSetMetaData.getColumnCount(); columnId++) {
                    userDetails.put(resultSetMetaData.getColumnName(columnId), resultSet.getObject(columnId));
                }
                result.add(userDetails);
            }
        } catch (Exception exception) {
            throw new UserNotFoundException("user Not Found");
        }

        return result;
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName       represents the table name
     * @param objectDetails   represents the object
     * @param conditionColumn retrieves the value from the field based on the specific condition 
     * @return true when detail is updated
     */
    public Boolean update(final Enum<TableName> tableName, final Map<String, Object> objectDetails,
                          final Map<String, Object> conditionColumn) {
        final StringJoiner column = new StringJoiner(",");
        final StringJoiner columnNames = new StringJoiner(" , ");
        final StringJoiner fieldValues = new StringJoiner(" , ");
        final StringBuilder updateQueryBuilder = new StringBuilder();
        final Collection<Object> valuesList = objectDetails.values();
        final Set<String> columnList = objectDetails.keySet();

        for (final String name : columnList) {
            column.add(name);
        }

        for (final Object value : valuesList) {
            fieldValues.add(value.toString());
        }

        for (final Map.Entry<String, Object> fields : conditionColumn.entrySet()) {
            columnNames.add(fields.getKey() + " = " + fields.getValue());
        }
        updateQueryBuilder.append("update ").append(tableName).append(" set ").append(column).append(" = ").append("'")
                .append(fieldValues).append("'").append(" where ").append(columnNames);

        try (Statement statement = ConnectDataBase.getInstance().getConnection().createStatement()) {
            return statement.executeUpdate(String.valueOf(updateQueryBuilder)) > 0;
        } catch (Exception exception) {
            throw new UserNotFoundException("userNameNotFound");
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param tableName     represents the table name
     * @param objectDetails represents the object
     * @return true when detail is deleted
     */
    public Boolean delete(final Enum<TableName> tableName, final Map<String, Object> objectDetails) {
        final StringJoiner columnNames = new StringJoiner(" , ");
        final StringBuilder deleteQueryBuilder = new StringBuilder();

        for (final Map.Entry<String, Object> fields : objectDetails.entrySet()) {
            columnNames.add(fields.getKey() + " = " + fields.getValue());
        }
        deleteQueryBuilder.append("Delete from ").append(tableName).append(" where ").append(columnNames);

        try (Statement statement = ConnectDataBase.getInstance().getConnection().createStatement()) {
            return statement.executeUpdate(String.valueOf(deleteQueryBuilder)) > 0;
        } catch (Exception exception) {
            throw new UserNotFoundException("userNotFound");
        }
    }
}