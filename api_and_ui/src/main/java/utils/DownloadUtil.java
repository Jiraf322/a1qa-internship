package utils;

import aquality.selenium.browser.AqualityServices;
import utils.dataProviders.ConfigDataProvider;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class DownloadUtil {

    //TODO: add exception to prevent reflection access
    private DownloadUtil(){
    }

    public static void downloadPhoto(String photoUrl) {
        try (InputStream is = new URL(photoUrl).openStream()) {
            AqualityServices.getLogger().info(String.format("Download Image by url: %s", photoUrl));
            Files.copy(is, Paths.get(new File(ConfigDataProvider.getActualPhotoPath()).getAbsolutePath()));
        } catch (IOException e) {
            AqualityServices.getLogger().error(String.format("Unchecked I/O exception, URL: %s",
                    photoUrl));
            throw new IllegalArgumentException("Unchecked I/O exception");
        }
    }
}
