package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionnaireDAOImpl;
import dao.UserDAOImpl;
import model.User;

@WebServlet("/UpdateQnaireStat")
public class UpdateQnaireStat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateQnaireStat() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	System.out.println("controller/UpdateQnaireStat: Start");
    	String sujetQnaire = request.getParameter("Qnaire sujet");
    	String stat = request.getParameter("Qnaire stat");
    	System.out.println("controller/UpdateQnaireStat: sujet = "+ sujetQnaire);
    	System.out.println("controller/UpdateQnaireStat: stat = "+ stat);
    	
    	QuestionnaireDAOImpl qnairedao = new QuestionnaireDAOImpl();
    	
    	RequestDispatcher dispatcher = null;
    	if(qnairedao.updateStat(sujetQnaire, stat)) {
    		dispatcher = request.getRequestDispatcher("/jsp/GererQnaire.jsp");
    	}else {
 			System.out.print("\nUser incorrect." );
 			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
     	}
    
    	dispatcher.forward(request, response);
    	System.out.println("controller/UpdateQnaireStat: End");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}	 	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
