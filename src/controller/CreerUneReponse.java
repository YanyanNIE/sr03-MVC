package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnswerDAOImpl;
import dao.QADAOImpl;
import model.Answer;
import model.QA;

@WebServlet("/CreerUneReponse")
public class CreerUneReponse extends HttpServlet {
	 
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException, SQLException {
				System.out.println("controller/CreerUneReponse: Start");
				String sujetQ = request.getParameter("Question sujet");
		    	String sujetA = request.getParameter("Answer sujet");
		    	String astat = request.getParameter("Answer stat");
//		    	String aresult = request.getParameter("Answer result");
		    	boolean aresult = Boolean.parseBoolean(request.getParameter("Answer result"));

				System.out.println("controller/CreerUneReponse: sujetQ="+sujetQ);
				System.out.println("controller/CreerUneReponse: sujetA="+sujetA);
				System.out.println("controller/CreerUneReponse: astat="+astat);
				System.out.println("controller/CreerUneReponse: aresult="+aresult);
				
		    	Answer ans = new Answer();
		    	AnswerDAOImpl ansdao = new AnswerDAOImpl();
		    	QA qa = new QA();
			    QADAOImpl qadao = new QADAOImpl();
			    
			    ans.setSujet(sujetA);
			    ans.setStatus(astat);
			    
			    
			    int maxorder = qadao.getMaxOrder(sujetQ);
			    qa.setSujetQ(sujetQ);
			    qa.setSujetA(sujetA);
			    qa.setOrder(maxorder+1);
			    qa.setCanswer(aresult);
			    
			    
		    	boolean resans = false;
		    	resans = ansdao.add(ans);
		    	
		    	boolean resqa = false;
		    	resqa = qadao.addA(qa);
		    	RequestDispatcher dispatcher = null;
		    	
		    	if(resans && resqa) {
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
