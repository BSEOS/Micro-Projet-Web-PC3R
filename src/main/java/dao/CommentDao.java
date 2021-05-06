package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Comment;
import controller.Utils;

public class CommentDao {
	public int creatComment(Comment comment) throws ClassNotFoundException, SQLException {
		final String DB_URL = "jdbc:mysql://localhost:3306/bdd_crypto_adviser?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		final String[] auth = Utils.getSQLAuth();
		final String USER = auth[0];
		final String PASS = auth[1];
        String INSERT_COMMENT_SQL = "INSERT INTO Comment" +
            "  (username, report_id, content, created_at) VALUES " +
            " (?, ?, ?, NOW());";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection(DB_URL, USER, PASS);

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENT_SQL)) {
            preparedStatement.setString(1, comment.getUsername());
            preparedStatement.setInt(2, comment.getReport_id());
            preparedStatement.setString(3, comment.getContent());

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        	throw e;

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
