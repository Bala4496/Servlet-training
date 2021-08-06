package ua.bala.dao;

import ua.bala.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final List<User> store = new ArrayList<>();

    public User getById(int id){
        User result = new User();
        result.setId(-1);

        for (User user: store){
            if (user.getId() == id)
                result = user;
        }

        return result;
    }

    public User getUserByLoginAndPassword(final String login, final String password){
        User result = new User();
        result.setId(-1);

        for (User user: store){
            if (user.getLogin().equals(login) &&
                    user.getPassword().equals(password))
                result = user;
        }

        return result;
    }

    public boolean add(final User newUser){

        for (User user: store){
            if (user.getLogin().equals(newUser.getLogin()) &&
                    user.getPassword().equals(newUser.getPassword()))
                return false;
        }
        return store.add(newUser);
    }

    public User.ROLE getRoleByLoginAndPassword(final String login,
                                               final String password){
        User.ROLE result = User.ROLE.UNKNOWN;

        for (User user: store){
            if (user.getLogin().equals(login) &&
                    user.getPassword().equals(password))
                result = user.getRole();
        }
        return result;
    }

    public boolean userIsExist(final String login,
                               final String password){
        boolean result = false;

        for (User user: store){
            if (user.getLogin().equals(login) &&
                    user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
