package service;

import dataaccess.DataAccess;
import datamodel.*;
import org.mindrot.jbcrypt.*;

public class UserService {
    private final DataAccess dataAccess;

    public UserService(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    public void clear() {
        dataAccess.clear();
    }

    public AuthData register(UserData user) throws Exception {
        validateNotEmpty(user.username());
        validateNotEmpty(user.password());
        validateNotEmpty(user.email());

        if (dataAccess.getUser(user.username()) != null) {
            throw new Exception("already exists");
        }
        var hashPwd = BCrypt.hashpw(user.password(), BCrypt.gensalt());
        var storeUser = new UserData(user.username(), user.email(), hashPwd);
        dataAccess.createUser(storeUser);
        var authData = new AuthData(user.username(), generateAuthToken());
        dataAccess.setAuth(authData);

        return authData;
    }

    public AuthData login(UserData user) throws Exception {
        validateNotEmpty(user.username());
        validateNotEmpty(user.password());

        var existingUser = dataAccess.getUser(user.username());
        if (existingUser == null || (!BCrypt.checkpw(user.password(), existingUser.password()))) {
            throw new Exception("invalid credentials");
        }

        var authData = new AuthData(user.username(), generateAuthToken());
        dataAccess.setAuth(authData);

        return authData;
    }

    private void validateNotEmpty(String param) throws Exception {
        if (param == null || param.isBlank()) {
            throw new Exception("invalid param");
        }

    }
    private String generateAuthToken(){
        return "xyz";
    }

}
