package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Trader;
import controller.Utils;


public class TraderDao {
    
	public int registerTrader(Trader trader) throws ClassNotFoundException {
		final String DB_URL = "jdbc:mysql://localhost:3306/bdd_crypto_adviser?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		final String[] auth = Utils.getSQLAuth();
		final String USER = auth[0];
		final String PASS = auth[1];
		
        String INSERT_TRADER_SQL = "INSERT INTO Trader" +
            "  (username, full_name, password, created_at) VALUES " +
            " (?, ?, ?, NOW());";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection(DB_URL, USER, PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRADER_SQL)) {
            preparedStatement.setString(1, trader.getUsername());
            preparedStatement.setString(2, trader.getFull_name());
            preparedStatement.setString(3, trader.getPassword());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }
	
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
