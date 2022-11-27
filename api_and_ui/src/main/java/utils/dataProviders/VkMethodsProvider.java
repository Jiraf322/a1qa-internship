package utils.dataProviders;

import utils.JsonGetter;
import static testData.TestConstants.*;

public final class VkMethodsProvider {

    private VkMethodsProvider() {
    }

    public static String getBaseApiUrl() {
        return JsonGetter.getStringData(BASE_API_URL_KEY);
    }

    public static String getVkApiVersion() {
        return JsonGetter.getStringData(VK_API_VERSION_KEY);
    }

    public static String getWallPost() {
        return JsonGetter.getStringData(WALL_POST_KEY);
    }

    public static String getWallEdit() {
        return JsonGetter.getStringData(WALL_EDIT_KEY);
    }

    public static String getWallPhotoUploadServer() {
        return JsonGetter.getStringData(WALL_PHOTO_UPLOAD_SERVER_KEY);
    }

    public static String getSaveWallPhoto() {
        return JsonGetter.getStringData(SAVE_WALL_PHOTO_KEY);
    }

    public static String getCreateComment() {
        return JsonGetter.getStringData(CREATE_COMMENT_KEY);
    }

    public static String getIsLiked() {
        return JsonGetter.getStringData(IS_LIKED_KEY);
    }

    public static int getLiked() {
        return JsonGetter.getIntData(LIKED_KEY);
    }

    public static String getDeletePost() {
        return JsonGetter.getStringData(POST_DELETE_KEY);
    }
}
