package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Adviser;
import beans.User;
import controller.Utils;

public class UserDao {
	public User getResult(ResultSet rs) throws SQLException {
		User resUser = null;
		if (rs.next()) {
			resUser = new User();
			resUser.setId(rs.getInt("id"));
			resUser.setUsername(rs.getString("username"));
			resUser.setFull_name(rs.getString("full_name"));
			resUser.setPassword(rs.getString("password"));
		}

		return resUser;
	}

	public User loginUser(User user) throws ClassNotFoundException {
		final String DB_URL = "jdbc:mysql://localhost:3306/bdd_crypto_adviser?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		final String[] auth = Utils.getSQLAuth();
		final String USER = auth[0];
		final String PASS = auth[1];

		String SELECT_QUERY = String.format("SELECT * FROM Trader WHERE username = \"%s\"", user.getUsername());

		User resUser = null;
		ResultSet rs = null;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
			System.out.println(preparedStatement);

			rs = preparedStatement.executeQuery();

			resUser = getResult(rs);
			if (resUser == null) {
				SELECT_QUERY = String.format("SELECT * FROM Adviser WHERE username = \"%s\"", user.getUsername());
				preparedStatement = connection.prepareStatement(SELECT_QUERY);
				rs = preparedStatement.executeQuery();
				resUser = getResult(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resUser;
	}
}
