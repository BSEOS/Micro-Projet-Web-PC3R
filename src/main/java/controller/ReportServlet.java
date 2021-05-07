package controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.Adviser;
import beans.Report;
import dao.ReportDao;

@WebServlet("/create-report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReportDao reportDao;

	public void init() {
		reportDao = new ReportDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reportID = request.getParameter("id");

		try {
			int id = Integer.parseInt(reportID);

			Report report = reportDao.getReport(id);
			String res = report.getJson();
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(res);
			out.flush();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/creatReport.jsp");
//		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String reportID = request.getParameter("id");

		Report report = new Report();
		report.setId(Integer.parseInt(reportID));

		try {
			reportDao.creatReport(report);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("reportdetails.jsp");
	}
}
