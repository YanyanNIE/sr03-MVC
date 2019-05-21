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


@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateProfile() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	System.out.println("controller/UpdateProfile: Start = ");
    	String login = request.getParameter("User login");
    	String pwd = request.getParameter("User password");
    	String fname = request.getParameter("User first name");
    	String lname = request.getParameter("User last name");
    	String identity = request.getParameter("User identity");
    	String society = request.getParameter("User society");
    	String stat = request.getParameter("User stat");
    	String phone = request.getParameter("User phone");
    	System.out.println("controller/UpdateProfile: getParams = "+login+pwd+fname+lname+identity+society+phone+stat);
    	
    	UserDAOImpl userdao = new UserDAOImpl();
    	User u = new User();
    	u.setLogin(login);
    	u.setPwd(pwd);
    	u.setFname(fname);
    	u.setLname(lname);
    	u.setIdentity(identity);
    	u.setSociety(society);
    	u.setPhone(phone);
    	u.setStat(stat);
    	System.out.println("controller/UpdateProfile: u.stat = "+u.getStat());
    	
    	
    	
    	RequestDispatcher dispatcher = null;
    	
    	if(userdao.updateProfile(u)) {
    		dispatcher = request.getRequestDispatcher("/jsp/profile.jsp");
    	}else {
    		dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
    	}
    	
    	dispatcher.forward(request, response);		
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
