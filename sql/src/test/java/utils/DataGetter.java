package utils;

import aquality.selenium.core.logging.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class DataGetter {

    public static Object getData(String path, Class clazz) {
        try {
            return new ObjectMapper().readValue(new File(path), clazz);
        } catch (IOException e) {
            Logger.getInstance().error(String.format("Unable to read data:\n%s" ,e.getMessage()));
        }
        return null;
    }
}
