package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;
import dao.AdviserDao;
import dao.TraderDao;
import dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/login-user")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	public LoginUserServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UserLogin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		User user = new User();
		user.setUsername(username);

		try {
			User resUser = userDao.loginUser(user);
			if(resUser == null || !password.equals(resUser.getPassword())) {
				//TODO Error
			}
			
			System.out.println(resUser);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
