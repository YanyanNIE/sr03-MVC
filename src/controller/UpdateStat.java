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
import dao.UserDAOImpl;
import model.User;

@WebServlet("/UpdateStat")
public class UpdateStat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateStat() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	System.out.println("controller/UpdateStat: Start");
    	String login = request.getParameter("User login");
    	String stat = request.getParameter("User stat");
    	System.out.println("controller/UpdateStat: login = "+ login);
    	System.out.println("controller/UpdateStat: stat = "+ stat);
    	UserDAOImpl userdao = new UserDAOImpl();
    	RequestDispatcher dispatcher = null;
    	if(userdao.updateStat(login, stat)) {
    		dispatcher = request.getRequestDispatcher("/jsp/result.jsp");
    	}else {
 			System.out.print("\nUser incorrect." );
 			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
     	}
    
    	dispatcher.forward(request, response);
    	System.out.println("controller/UpdateStat: End");
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
