package udSah.practice.Services;

import udSah.practice.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private Map<Long, User> userDB = new HashMap<>();

    public User createUser(User userReq) {
        userDB.put(userReq.getId(), userReq);
        return userReq;
    }

    public List<User> getAllUsers() {

        List<User> usersResp = new ArrayList<>();

        for (User user : userDB.values()) {
            usersResp.add(user);
        }

        return usersResp;
    }

    public User getUserById(Long id) {
        return userDB.get(id);
    }

    public void deleteUser(Long id) {
        userDB.remove(id);
    }
}