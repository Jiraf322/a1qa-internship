package utils;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import utils.dataProviders.ConfigDataProvider;
import java.awt.image.BufferedImage;
import java.io.File;

public final class ImageComparisonUtils {

    private ImageComparisonUtils() {
    }

    public static boolean compareImages(String actualImg, String expectedImg){
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(expectedImg);
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(actualImg);
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage).compareImages();
        return ImageComparisonState.MATCH.equals(imageComparisonResult.getImageComparisonState());
    }

    public static void deleteComparedImage() {
        File file = new File(ConfigDataProvider.getActualPhotoPath());
        if (file.exists()) {
            file.delete();
        }
    }
}
