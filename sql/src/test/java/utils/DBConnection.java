package utils;

import aquality.selenium.core.logging.Logger;
import jsondata.ConfigDataProvider;
import models.Credentials;
import java.sql.*;

public class DBConnection {

    private static Connection connection = null;
    private static final Credentials credentials = (Credentials) DataGetter.getData(ConfigDataProvider.getCredentialsPath(),
            Credentials.class);

    private static boolean isConnectionClosed(Connection connectionToCheck) {
        Boolean isConnectionClosed = null;
        try {
            isConnectionClosed = connectionToCheck.isClosed();
        } catch (SQLException e) {
            Logger.getInstance().error(String.format("Error while trying to: %s", e.getMessage()));
        }
        return isConnectionClosed;
    }

    public static Connection getInstance() {
        if (connection == null || isConnectionClosed(connection)) {
            try {
                if (credentials != null) {
                    connection = DriverManager.getConnection(credentials.getLocalUrl() + credentials.getJdbcNameDB(),
                            credentials.getJdbcUsername(), credentials.getJdbcPassword());
                }
                return connection;
            } catch (SQLException e) {
                Logger.getInstance().error(String.format("Error while trying to: %s", e.getMessage()));
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            Logger.getInstance().error(String.format("Error while trying to: %s", e.getMessage()));
        }
    }
}