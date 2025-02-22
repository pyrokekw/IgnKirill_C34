package domain;

public class User {
    private String login;
    private String password;
    private String order;

    public User(String login, String password, String order) {
        this.login = login;
        this.password = password;
        this.order = order;
    }

    public String getLogin() {
        return login;
    }

    public String getOrder() {
        return order;
    }
}
