import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AutorisationService {

    private List<User> users;

    public AutorisationService() {
        this.users = Arrays.asList(new User("admin", "admin", "admin"), new User("Vlad", "Sabaka", "Batya"));

    }


    public User auth(String login, String password) {
        User user = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)) {
                user = users.get(i);
            }
        }
        return user;
    }

}
