package models;

public class Credentials {

    private String login;
    private String password;
    private String token;

    public Credentials(String login, String password, String token) {
        this.login = login;
        this.password = password;
        this.token = token;
    }

    public Credentials() {}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }
}
