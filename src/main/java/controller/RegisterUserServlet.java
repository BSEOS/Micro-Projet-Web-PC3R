package controller;

import java.io.IOException;

import beans.*;

import dao.AdviserDao;
import dao.TraderDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet(description = "Servlet to register user(trader/adviser)", urlPatterns = { "/register-user" })
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdviserDao adviserDao;
	private TraderDao traderDao;

	public void init() {
		adviserDao = new AdviserDao();
		traderDao = new TraderDao();
	}

	public RegisterUserServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/UserRegister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String role = request.getParameter("role");
		final String username = request.getParameter("username");
		final String full_name = request.getParameter("full_name");
		final String password = request.getParameter("password");
		final String passwordConfirm = request.getParameter("password-confirm");
		if (!password.equals(passwordConfirm)) {
			// TODO
			// Return error
		}

		User user = new User();
		user.setUsername(username);
		user.setFull_name(full_name);
		user.setPassword(password);

		try {
			if (role.equals("adviser")) {
				Adviser adviser = new Adviser();
				adviser.setUsername(username);
				adviser.setFull_name(full_name);
				adviser.setPassword(password);
				adviserDao.registerAdviser(adviser);
			} else {
				Trader trader = new Trader();
				trader.setUsername(username);
				trader.setFull_name(full_name);
				trader.setPassword(password);
				traderDao.registerTrader(trader);
			}

			response.sendRedirect("adviserdetails.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
