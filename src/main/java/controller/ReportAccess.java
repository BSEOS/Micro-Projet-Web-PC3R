package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reports")
public class ReportAccess extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
		final String DB_URL="jdbc:mysql://localhost:3306/bdd_crypto_adviser?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";

		final String USER = "root";
		final String PASS = "";

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Reports Result";
		out.println("<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n");
		try{
			Class.forName(JDBC_DRIVER);

			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

			Statement stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM report";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				int id_report  = rs.getInt("id_report");
				int idviser_id  = rs.getInt("idviser_id");
				int crypto_id  = rs.getInt("crypto_id");
				String title1 = rs.getString("title");
				String content = rs.getString("content");

				out.println("Id : " + id_report);
				out.println(", id adviser: " + idviser_id);
				out.println(", id crypto : " + crypto_id);
				out.println(", title : " + title1);
				out.println(", content : " + content+"<br>");
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