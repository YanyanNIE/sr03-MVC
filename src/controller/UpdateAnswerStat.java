package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnswerDAOImpl;

@WebServlet("/UpdateAnswerStat")
public class UpdateAnswerStat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateAnswerStat() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	System.out.println("controller/UpdateAnswerStat: Start");
    	String sujet = request.getParameter("Answer sujet");
    	String stat = request.getParameter("Answer stat");
    	System.out.println("controller/UpdateAnswerStat: sujet = "+ sujet);
    	System.out.println("controller/UpdateAnswerStat: stat = "+ stat);
    	
    	AnswerDAOImpl ansdao = new AnswerDAOImpl();
    	
    	RequestDispatcher dispatcher = null;
    	if(ansdao.updateStat(sujet, stat)) {
    		dispatcher = request.getRequestDispatcher("/jsp/result.jsp");
    	}else {
 			System.out.print("\nUser incorrect." );
 			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
     	}
    
    	dispatcher.forward(request, response);
    	System.out.println("controller/UpdateAnswerStat: End");
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
