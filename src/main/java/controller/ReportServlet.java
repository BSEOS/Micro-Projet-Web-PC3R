package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.Adviser;
import beans.Report;
import dao.ReportDao;

@WebServlet("/creatReport")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReportDao reportDao;
    
    public void init() {
    	reportDao = new ReportDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	response.getWriter().append("Served at: ").append(request.getContextPath());
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/creatReport.jsp");
    	dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String idviser_id = request.getParameter("idviser_id");
        String crypto_id = request.getParameter("crypto_id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Report report = new Report();
        report.setId_report(Integer.parseInt(idviser_id));
        report.setCrypto_id(Integer.parseInt(crypto_id));
        report.setTitle(title);
        report.setContent(content);

        try {
            reportDao.creatReport(report);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("reportdetails.jsp");
    }
}
