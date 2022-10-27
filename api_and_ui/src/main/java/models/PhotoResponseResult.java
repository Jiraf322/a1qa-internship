package models;

import io.restassured.response.ResponseBody;

public class PhotoResponseResult {

    private ResponseBody responseBody;
    private int server;
    private String photo;
    private String hash;

    public PhotoResponseResult(ResponseBody responseBody) {
        this.server = responseBody.jsonPath().get("server");
        this.photo = responseBody.jsonPath().get("photo");
        this.hash = responseBody.jsonPath().get("hash");
    }

    public int getServer() {
        return server;
    }

    public void setServer(int server) {
        this.server = server;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
