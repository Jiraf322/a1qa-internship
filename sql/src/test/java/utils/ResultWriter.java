package utils;

import aquality.selenium.core.logging.Logger;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultWriter {

    private static FileWriter fos;

    static {
        try {
            fos = new FileWriter(DataUtil.getLogName());
        } catch (IOException e) {
            Logger.getInstance().error(String.format("Unable to create log file:\n%s", e.getMessage()));
        }
    }

    public static void LogWriter(ResultSet resultSet) {
        CSVWriter writer = new CSVWriter(fos);
        try {
            writer.writeAll(resultSet, true);
            fos.write("\n");
            writer.flush();
        } catch (SQLException | IOException e) {
            Logger.getInstance().error(String.format("Unable to write log:\n%s", e.getMessage()));
        }
    }
}
