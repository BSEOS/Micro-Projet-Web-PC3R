package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Adviser;
import beans.Crypto;
import dao.CryptoDao;

@WebServlet("/creatCrypto")
public class CryptoServlet extends HttpServlet  {
	 private static final long serialVersionUID = 1L;
	 private CryptoDao cryptoDao;
	
	 public void init() {
		 cryptoDao = new CryptoDao();
	 }	 
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	    			throws ServletException, IOException{
		 response.getWriter().append("Served at: ").append(request.getContextPath());  	
	     RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/creatCrypto.jsp");
	     dispatcher.forward(request, response);
	 }
	 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {

	    	String name = request.getParameter("name");
	    	String price = request.getParameter("price");

	    	        Crypto crypto = new Crypto();
	    	        crypto.setName(name);
	    	        crypto.setPrice(Double.parseDouble(price));

	    	        try {
	    	            cryptoDao.creatCrypto(crypto);
	    	        } catch (Exception e) {
	    	            e.printStackTrace();
	    	        }
	    	        response.sendRedirect("cryptodetails.jsp");
	    	    }
}
