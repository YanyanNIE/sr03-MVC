package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Question;

@WebServlet("/CreerUnQuestion")
public class CreerUnQuestion extends HttpServlet {
	private static Hashtable<Integer, Question> questionsTable= new Hashtable<Integer, Question>();
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {		 
		  
		 
		
		
	 }
	 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 //processRequest(request, response);
	 }

	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 processRequest(request, response);
	 }

@Override
public String getServletInfo() {
return "Short description";
}// </editor-fold>

}

