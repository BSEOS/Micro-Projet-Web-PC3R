package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/traders")
public class TraderAccess extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
										throws ServletException, IOException {

		final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
		final String DB_URL="jdbc:mysql://localhost:3306/bdd_crypto_adviser?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

		final String USER = "root";
		final String PASS = "";

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Traders Result";
		out.println("<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n");
		try{
			Class.forName(JDBC_DRIVER);

			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM trader";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				int id  = rs.getInt("id");
				String username = rs.getString("username");
				String full_name = rs.getString("full_name");

				out.println("Id : " + id);
				out.println(", Username: " + username);
				out.println(", Full name : " + full_name+"<br>");
			}
			out.println("</body></html>");

			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
