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
//import com.run.test.User;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	
    	String login = request.getParameter("User Login");
    	String pwd = request.getParameter("User password");
    	UserDAOImpl userdao = new UserDAOImpl();
    	User u = new User();
    	u = userdao.findByLogin(login);
    	System.out.println("test: user find = "+u);
    	
    	RequestDispatcher dispatcher = null;
    	request.setAttribute("User fname", u.getFname());
    	request.setAttribute("User lname", u.getLname());
    	if(u.getPwd()!=null){
    		if(u.getPwd().equals(pwd)) {
    			if(u.getIndentity().equals("admin")) {
        			dispatcher = request.getRequestDispatcher("/jsp/adminPage.jsp");
        		}else {
        			dispatcher = request.getRequestDispatcher("/jsp/stagePage.jsp");
        		}
    		}else {
    			System.out.print("\nPassword incorrect." );
    			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
    		}
    	}else {
			System.out.print("\nUser incorrect." );
			request.getRequestDispatcher("/jsp/error.jsp");
    	}
    	dispatcher.forward(request, response);		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}	 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
