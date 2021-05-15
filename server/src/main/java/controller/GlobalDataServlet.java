package controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.JsonElement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wrappers.coinlore.CoinLoreWrapper;

/**
 * Servlet implementation class GlobalDataServlet
 */
@WebServlet("/global")
public class GlobalDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public GlobalDataServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoinLoreWrapper clw = new CoinLoreWrapper();
		JsonElement elem = clw.getGlobal();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(elem.toString());
		out.flush();
	}


}
