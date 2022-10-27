package utils.api;

import models.PhotoResponseResult;
import models.apimodels.ResponseResult;
import utils.dataProviders.ConfigDataProvider;
import utils.dataProviders.VkMethodsProvider;
import static testData.TestConstants.RESPONSE_UPLOAD_URL_KEY;
import static testData.TestConstants.TYPE_PHOTO_KEY;

public class UploadPhotoSteps {

    public static ResponseResult getWallPhotoServerResponse() {
        var specification = RestApiUtils.requestBuilder(VkMethodsProvider.getWallPhotoUploadServer()).build();
        return new ResponseResult(ApiUtils.doPost(specification));
    }

    public static String getUploadUrl(ResponseResult responseResult) {
        return responseResult.getResult().path(RESPONSE_UPLOAD_URL_KEY);
    }

    public static PhotoResponseResult uploadPhotoOnTheWall(String uploadUrl) {
        var responseResult = new ResponseResult(ApiUtils.doMultipartPost(uploadUrl, ConfigDataProvider.getPhotoPath(),
                TYPE_PHOTO_KEY));
        return new PhotoResponseResult(responseResult.getResult());
    }

    public static ResponseResult saveUploadWallPhoto(PhotoResponseResult photoResponseResult) {
        var specification = RestApiUtils.requestBuilder(VkMethodsProvider.getSaveWallPhoto())
                .addParam("hash", photoResponseResult.getHash())
                .addParam("server", photoResponseResult.getServer())
                .addParam("photo", photoResponseResult.getPhoto())
                .build();
        return new ResponseResult(ApiUtils.doPost(specification));
    }
}
