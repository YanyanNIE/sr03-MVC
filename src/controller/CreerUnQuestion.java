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

import dao.QQDAOImpl;
import dao.QuestionDAOImpl;
import dao.QuestionnaireDAOImpl;
import model.QQ;
import model.Question;
import model.Questionnaire;

@WebServlet("/CreerUnQuestion")
public class CreerUnQuestion extends HttpServlet {
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException, SQLException {
		System.out.println("controller/CreerUnQuestion: Start");
		String sujetQnaire = request.getParameter("Questionnaire sujet");
    	String sujetQn = request.getParameter("Question sujet");
    	String stat = request.getParameter("Question stat");
    	
    	Question qn = new Question();
    	QuestionDAOImpl qndao = new QuestionDAOImpl();
    	QQ qq = new QQ();
	    QQDAOImpl qqdao = new QQDAOImpl();
	    
	    qn.setSujet(sujetQn);
	    qn.setStatus(stat);
	    
	    
	    int maxorder = qqdao.getMaxOrder(sujetQnaire);
	    qq.setSujetQn(sujetQn);
	    qq.setSujetQnaire(sujetQnaire);
	    qq.setOrder(maxorder+1);
	    
    	boolean resqn = false;
    	resqn = qndao.add(qn);
    	
    	boolean resqq = false;
    	resqq = qqdao.add(qq);
    	RequestDispatcher dispatcher = null;
    	
    	if(resqn && resqq) {
    		dispatcher = request.getRequestDispatcher("/jsp/result.jsp");
    	} else{
    		dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
    	}
    	dispatcher.forward(request, response);
    	System.out.println("controller/CreerUnQuestion: End");
		
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


