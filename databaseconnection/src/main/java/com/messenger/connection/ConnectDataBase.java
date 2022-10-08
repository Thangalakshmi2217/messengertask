package com.messenger.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.messenger.exception.ConnectionNotFoundException;

/**
 * <p>
 *     Provides the connection to the database.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class ConnectDataBase {
    private static ConnectDataBase connectDataBase;

    private ConnectDataBase() {
    }

    /**
     * <p>
     *     Returns {@link ConnectDataBase} instance.
     * </p>
     *
     * @return the connection database instance
     */
    public static ConnectDataBase getInstance() {

        if (connectDataBase == null) {
            connectDataBase = new ConnectDataBase();
        }

        return connectDataBase;
    }

    /**
     * <p>
     *     Gets the {@link Connection} through driver manager and connects the database using the localhost path, username
     *     and password provided and returns the connection.
     * </p>
     *
     * @return the {@link Connection} to the database.
     * @exception ConnectionNotFoundException will be thrown, when it is not connected to the database
     */
    public Connection getConnection() {
        try (InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream("DatabaseDetails.properties")) {
            final Properties PROPERTIES = new Properties();

            PROPERTIES.load(inputStream);
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("username"),
                    PROPERTIES.getProperty("password"));
        } catch (Exception exception) {
            throw new ConnectionNotFoundException("DataBase Not Connected");
        }
    }
}