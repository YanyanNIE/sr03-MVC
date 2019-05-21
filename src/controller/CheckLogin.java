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



@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CheckLogin() {
        super();
      
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	System.out.println("controller/CheckLogin: Start");
    	String login = request.getParameter("User Login");
    	String pwd = request.getParameter("User password");
    	UserDAOImpl userdao = new UserDAOImpl();
    	User u = new User();
    	u = userdao.findByLogin(login);
    	System.out.println("controller/CheckLogin: User founded = "+u);
    	
    	RequestDispatcher dispatcher = null;
    	request.setAttribute("fname", u.getFname());
    	request.setAttribute("lname", u.getLname());
    	
    	PrintWriter out = response.getWriter();

    	if(u.getStat().equals("inactif")) {
    		out.write("User inactif");
			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
		}else if(u.getPwd()!=null){
    		if(u.getPwd().equals(pwd)) {
    			request.getSession().setAttribute("user", u);
    			if(u.getIndentity().equals("admin")) {
        			dispatcher = request.getRequestDispatcher("/jsp/adminPage.jsp");
        		}else {
        			dispatcher = request.getRequestDispatcher("/jsp/stagePage.jsp");
        		}
    		}else {
    			System.out.print("\nPassword incorrect." );
    			out.write("Password incorrect");
    			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
    		}
    	}else {
			System.out.print("\nUser incorrect." );
			out.write("User incorrect");
			request.getRequestDispatcher("/jsp/error.jsp");
    	}
    	dispatcher.forward(request, response);
    	System.out.println("controller/CheckLogin: End");
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
