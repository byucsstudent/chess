package service;

import dataaccess.DataAccess;
import datamodel.*;

public class UserService {
    private final DataAccess dataAccess;

    public UserService(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public void clear() {
        dataAccess.clear();
    }

    public AuthData register(UserData user) throws Exception {
        if (user.username() == null || user.username().isBlank()) {
            throw new Exception("invalid username");
        }
        if (dataAccess.getUser(user.username()) != null) {
            throw new Exception("already exists");
        }
        dataAccess.createUser(user);
        var authData = new AuthData(user.username(), generateAuthToken());

        return authData;
    }

    private String generateAuthToken(){
        return "xyz";
    }

}
