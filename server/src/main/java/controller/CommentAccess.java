package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Comment;
import beans.Report;
import dao.CommentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/comment")
public class CommentAccess extends HttpServlet {
	private CommentDao commentDao;

	public void init() {
		commentDao = new CommentDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentID = request.getParameter("id");
		if (commentID == null || commentID.isEmpty() || commentID.isBlank()) {
			// TODO
		}

		try {
			int id = Integer.parseInt(commentID);

			Comment comment = commentDao.getComment(id);
			if (comment == null) {
				// TODO error
			} else {
				String res = comment.getJson();
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(res);
				out.flush();
			}
		} catch (Exception e) {
			// TODO error
			e.printStackTrace();
		}

	}
}