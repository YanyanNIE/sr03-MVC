package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionnaireDAOImpl;
import model.Questionnaire;

@WebServlet("/CreerUnQuestionnaire")
public class CreerUnQuestionnaire extends HttpServlet {
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException, SQLException {
		System.out.println("controller/CreerUnQuestionnaire: Start");
    	String sujetQnaire = request.getParameter("Questionnaire sujet");
    	String stat = request.getParameter("Questionnaire stat");
    	
    	Questionnaire qnaire = new Questionnaire();
	    QuestionnaireDAOImpl qnairedao = new QuestionnaireDAOImpl();
	    
	    qnaire.setSujet(sujetQnaire);
	    qnaire.setStatus(stat);
	    
    	boolean resSQL = false;
    	resSQL = qnairedao.add(qnaire);
    	RequestDispatcher dispatcher = null;
    	
    	if(resSQL) {
    		dispatcher = request.getRequestDispatcher("/jsp/GererQnaire.jsp");
    	} else{
    		dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
    	}
    	dispatcher.forward(request, response);
    	System.out.println("controller/CreerUnQuestionnaire: End");
		
	 }
	 
	 @Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
		 try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }

	 @Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
		 try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
}
