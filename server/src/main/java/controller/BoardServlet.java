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
 * Servlet implementation class BoardServlet
 */
@WebServlet(description = "Main Board of crypto-currencies", urlPatterns = { "/board" })
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * @return list of cryptos with rank in [s,..,e]
	 * 			if params not contains s&e returns top10 cryptos
	 * 
	 * 
	 * http://localhost:8080/crypto-adviser/board
	 * return top10 cryptos
	 * 
	 * http://localhost:8080/crypto-adviser/board?s=10&e=22
	 * returns crypos with the ranks between 10 and 22 inclusive
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CoinLoreWrapper clw = new CoinLoreWrapper();
		String res = "";
		String s = request.getParameter("s");
		String e = request.getParameter("e");
		if (s == null && e == null) {
			res = clw.getTop10Coins();
		} else {
			int start = s == null ? 1 : Integer.parseInt(s);
			int end = e == null ? 1 : Integer.parseInt(e);

			res = clw.getTopCoins(start - 1, end - start + 1);
		}

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(res);
		out.flush();
	}

}
