package utils.api;

import utils.dataProviders.ConfigDataProvider;
import utils.dataProviders.VkMethodsProvider;
import models.apimodels.ResponseResult;
import static testData.TestConstants.RESPONSE_LIKED_KEY;

public class VkApiUtils {

    public static ResponseResult createPost(String str) {
        var specification = RestApiUtils.requestBuilder(VkMethodsProvider.getWallPost())
                .addParam("message", str).build();
        return new ResponseResult(ApiUtils.doPost(specification));
    }

    public static ResponseResult editPostOnTheWall(String str, String postId, String photoId) {
        var specification = RestApiUtils.requestBuilder(VkMethodsProvider.getWallEdit())
                .addParam("post_id", postId)
                .addParam("message", str)
                .addParam("attachments", String.format("photo%s_%s", ConfigDataProvider.getUserId(), photoId))
                .build();
        return new ResponseResult(ApiUtils.doPost(specification));
    }

    public static ResponseResult createCommentOnPost(String str, String postId) {
        var specification = RestApiUtils.requestBuilder(VkMethodsProvider.getCreateComment())
                .addParam("message", str)
                .addParam("post_id", postId)
                .build();
        return new ResponseResult(ApiUtils.doPost(specification));
    }

    public static boolean isPostLikedByAuthor(String postId) {
        var specification = RestApiUtils.requestBuilder(VkMethodsProvider.getIsLiked())
                .addParam("type", "post")
                .addParam("item_id", postId)
                .build();
        var responseResult = new ResponseResult(ApiUtils.doPost(specification));
        return responseResult.getResult().path(RESPONSE_LIKED_KEY).equals(VkMethodsProvider.getLiked());
    }

    public static ResponseResult deletePost(String postId) {
        var specification = RestApiUtils.requestBuilder(VkMethodsProvider.getDeletePost())
                .addParam("post_id", postId)
                .build();
        return new ResponseResult(ApiUtils.doPost(specification));
    }
}
