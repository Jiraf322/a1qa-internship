package utils.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.dataProviders.VkMethodsProvider;
import java.io.File;
import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response doGet(String urn) {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .get(VkMethodsProvider.getBaseApiUrl() + urn)
                .then()
                .extract()
                .response();
    }

    public static Response doPost(RequestSpecification spec) {
        return given(spec)
                .post()
                .then()
                .extract()
                .response();
    }

    public static Response doMultipartPost(String uploadUrl, String path, String typeOfFile) {
        return given()
                .multiPart(typeOfFile, new File(path))
                .post(uploadUrl)
                .then()
                .extract()
                .response();
    }
}