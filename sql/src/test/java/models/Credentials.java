package models;

public class Credentials {

    private String jdbcNameDB;
    private String jdbcUsername;
    private String jdbcPassword;
    private String localUrl;

    public Credentials() {
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public String getJdbcNameDB() {
        return jdbcNameDB;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }
}
