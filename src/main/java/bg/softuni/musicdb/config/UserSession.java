package bg.softuni.musicdb.config;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class UserSession {

    private String id;
    private String username;

    public void login(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public boolean isLoggedIn() {
        return id != null;
    }

    public String id() {
        return id;
    }

    private String username() {
        return username;
    }

    public void logout() {
        id = null;
        username = null;
    }
}
