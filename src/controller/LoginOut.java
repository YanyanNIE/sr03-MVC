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
import javax.servlet.http.HttpSession;

import dao.UserDAOImpl;
import model.User;


@WebServlet("/LoginOut")
public class LoginOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginOut() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	System.out.println("controller/LoginOut: Start");
    	HttpSession session = request.getSession(false);
    	RequestDispatcher dispatcher = null;
		if(session == null){
			dispatcher = request.getRequestDispatcher("/index.jsp");
			return;
		}	
		session.removeAttribute("user");
		dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);		
		System.out.println("controller/LoginOut: End");
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
