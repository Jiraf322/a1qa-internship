package models.apimodels;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ResponseResult {

    private int statusCode;
    private String contentType;
    private ResponseBody result;

    public ResponseResult(Response response) {
        this.statusCode = response.getStatusCode();
        this.contentType = response.getContentType();
        this.result = response.getBody();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public ResponseBody getResult() {
        return result;
    }

    public void setResult(ResponseBody result) {
        this.result = result;
    }
}