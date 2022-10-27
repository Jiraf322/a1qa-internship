package utils.api;

import io.restassured.builder.RequestSpecBuilder;
import utils.dataProviders.ConfigDataProvider;
import utils.dataProviders.DataProvider;
import utils.dataProviders.VkMethodsProvider;
import models.apimodels.ResponseResult;
import utils.StringUtils;
import static testData.TestConstants.*;

public class RestApiUtils {

    public static RequestSpecBuilder requestBuilder(String method) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        return builder
                .setBaseUri(VkMethodsProvider.getBaseApiUrl() + method)
                .addParam("owner_id", ConfigDataProvider.getUserId())
                .addParam("access_token", DataProvider.getCredentials().getToken())
                .addParam("v", VkMethodsProvider.getVkApiVersion());
    }

    public static String getIdFromPost(ResponseResult responseResult) {
        return responseResult.getResult().path(RESPONSE_POST_ID_KEY).toString();
    }

    public static String getIdFromUploadedPhoto(ResponseResult responseResult) {
        return StringUtils.getStringWithoutBrackets(responseResult.getResult().path(RESPONSE_ID_KEY).toString());
    }

}
