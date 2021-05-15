package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Adviser;
import controller.Utils;

public class AdviserDao {
	public int registerAdviser(Adviser adviser) throws ClassNotFoundException {
		final String DB_URL = "jdbc:mysql://localhost:3306/bdd_crypto_adviser?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		final String[] auth = Utils.getSQLAuth();
		final String USER = auth[0];
		final String PASS = auth[1];
		
		String INSERT_ADVISERS_SQL = "INSERT INTO Adviser" + "  (username, full_name, password, created_at) VALUES "
				+ " (?, ?, ?, NOW());";

		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADVISERS_SQL)) {
			preparedStatement.setString(1, adviser.getUsername());
			preparedStatement.setString(2, adviser.getFull_name());
			preparedStatement.setString(3, adviser.getPassword());

			System.out.println(preparedStatement);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
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
