package dataaccess;

import datamodel.UserData;

public class SqlDataAccess implements DataAccess{
    public SqlDataAccess() throws DataAccessException {
        DatabaseManager.createDatabase();
    }

    @Override
    public void clear() {

    }

    @Override
    public void createUser(UserData user) {

    }

    @Override
    public UserData getUser(String username) {
        return null;
    }
}
