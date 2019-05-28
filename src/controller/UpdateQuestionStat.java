package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAOImpl;

@WebServlet("/UpdateQuestionStat")
public class UpdateQuestionStat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateQuestionStat() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	System.out.println("controller/UpdateQuestionStat: Start");
    	String sujet = request.getParameter("Question sujet");
    	String stat = request.getParameter("Question stat");
    	System.out.println("controller/UpdateQuestionStat: sujet = "+ sujet);
    	System.out.println("controller/UpdateQuestionStat: stat = "+ stat);
    	
    	QuestionDAOImpl qndao = new QuestionDAOImpl();
    	
    	RequestDispatcher dispatcher = null;
    	if(qndao.updateStat(sujet, stat)) {
    		dispatcher = request.getRequestDispatcher("/jsp/result.jsp");
    	}else {
 			System.out.print("\nUser incorrect." );
 			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
     	}
    
    	dispatcher.forward(request, response);
    	System.out.println("controller/UpdateQuestionStat: End");
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
