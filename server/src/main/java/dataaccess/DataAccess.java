package dataaccess;

import datamodel.*;

public interface DataAccess {
    void clear();
    void createUser(UserData user) throws DataAccessException;
    UserData getUser(String username) throws DataAccessException;
    void setAuth(AuthData authData);
}
