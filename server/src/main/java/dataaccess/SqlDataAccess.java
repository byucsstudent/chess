package dataaccess;

import datamodel.AuthData;
import datamodel.UserData;

import java.sql.SQLException;

public class SqlDataAccess implements DataAccess{
    public SqlDataAccess() throws DataAccessException {
        DatabaseManager.createDatabase();
    }

    @Override
    public void clear() {

    }

    @Override
    public void createUser(UserData user) throws DataAccessException{
        try (var conn = DatabaseManager.getConnection()) {
        } catch (Exception ex) {
            throw new DataAccessException(ex.getMessage());
        }
    }

    @Override
    public UserData getUser(String username) throws DataAccessException {
        try (var conn = DatabaseManager.getConnection()) {
        } catch (Exception ex) {
            throw new DataAccessException(ex.getMessage());
        }
        return null;
    }

    @Override
    public void setAuth(AuthData authData) {

    }
}
