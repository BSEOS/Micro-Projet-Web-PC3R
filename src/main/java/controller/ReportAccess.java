package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Report;
import dao.ReportDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/report")
public class ReportAccess extends HttpServlet {
	private ReportDao reportDao;

	public void init() {
		reportDao = new ReportDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportID = request.getParameter("id");
		if (reportID == null || reportID.isEmpty() || reportID.isBlank()) {
			// TODO error
		}

		try {
			int id = Integer.parseInt(reportID);

			Report report = reportDao.getReport(id);
			if (report == null) {
				// TODO
			} else {
				String res = report.getJson();
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(res);
				out.flush();
			}
		} catch (Exception e) {
			
			//TODO Error
			e.printStackTrace();
		}

	}
}