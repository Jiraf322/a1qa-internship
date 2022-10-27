package utils;

import aquality.selenium.core.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {

    private static Statement statement = null;

    private static boolean isStatementClosed(Statement statementToCheck) {
        Boolean isStatementClosed = null;
        try {
            statementToCheck.close();
            isStatementClosed = statementToCheck.isClosed();
        } catch (SQLException e) {
            Logger.getInstance().error(String.format("Error while trying to: %s", e.getMessage()));
        }
        return isStatementClosed;
    }

    private static void closeStatement(Statement statementToClose) {
        if (statement != null || !isStatementClosed(statement)) {
            try {
                statementToClose.close();
            } catch (SQLException e) {
                Logger.getInstance().error(String.format("Error while trying to: %s", e.getMessage()));
            }
        }
    }

    public static ResultSet select(String query) {
        if (statement == null || isStatementClosed(statement)) {
            try {
                statement = DBConnection.getInstance().createStatement();
                var statementResult = statement.executeQuery(query);
                ResultWriter.LogWriter(statementResult);
                return statement.executeQuery(query);
            } catch (SQLException e) {
                Logger.getInstance().error(String.format("Error while trying to: %s", e.getMessage()));
            } finally {
                closeStatement(statement);
            }
        }
        return null;
    }
}
