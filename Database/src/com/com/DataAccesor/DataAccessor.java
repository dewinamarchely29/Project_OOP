package com.com.DataAccesor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessor {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DataAccessor(Connection connection) {
        this.connection = connection;
        this.statement = null;
        this.resultSet = null;
    }
    
    public void closeConnection() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public int executeUpdate(String query) throws SQLException {
        statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
}
