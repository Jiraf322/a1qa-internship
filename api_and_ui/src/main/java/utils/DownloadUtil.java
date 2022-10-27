package utils;

import aquality.selenium.browser.AqualityServices;
import utils.dataProviders.ConfigDataProvider;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadUtil {

    public static void downloadPhoto(String photoUrl) {
        try {
            AqualityServices.getLogger().info(String.format("Download Image by url: %s", photoUrl));
            InputStream in = new URL(photoUrl).openStream();
            Files.copy(in, Paths.get(new File(ConfigDataProvider.getActualPhotoPath()).getAbsolutePath()));
        } catch (IOException e) {
            AqualityServices.getLogger().error(String.format("Image with was not found by URL: %s",
                    photoUrl));
            throw new IllegalArgumentException("Image not found");
        }
    }
}
