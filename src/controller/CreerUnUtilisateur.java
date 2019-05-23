package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAOImpl;
import model.User;

@WebServlet("/CreerUnUtilisateur")
public class CreerUnUtilisateur extends HttpServlet {
	private static Hashtable<Integer, User> usersTable= new Hashtable<Integer, User>();
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		java.util.Date date = new java.util.Date();
		java.sql.Date cdate = new java.sql.Date(date.getTime());
		
		String login = request.getParameter("User login");
    	String pwd = request.getParameter("User password");
    	String fname = request.getParameter("User first name");
    	String lname = request.getParameter("User last name");
    	String identity = request.getParameter("User identity");
    	String society = request.getParameter("User society");
    	String phone = request.getParameter("User phone");
    	String stat = request.getParameter("User stat");
    	
    	
    	User u = new User();
    	u.setLogin(login);
    	u.setPwd(pwd);
    	u.setFname(fname);
    	u.setLname(lname);
    	u.setIdentity(identity);
        u.setSociety(society);
        u.setPhone(phone);
        u.setCdate(cdate);
        u.setStat(stat);
    	
    	
    	
    	UserDAOImpl userdao = new UserDAOImpl();
    	boolean resSQL = false;
    	resSQL = userdao.add(u);
    	RequestDispatcher dispatcher = null;
    	
    	if(resSQL) {
    		dispatcher = request.getRequestDispatcher("/jsp/GererUsers.jsp");
    	} else{
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
