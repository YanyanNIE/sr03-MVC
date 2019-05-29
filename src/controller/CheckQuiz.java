package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CourseDAOImpl;
import dao.QADAOImpl;
import dao.QQDAOImpl;
import dao.QuestionDAOImpl;
import model.ChoixQA;
import model.Course;
import model.Question;
import model.Questionnaire;
import model.User;



@WebServlet("/CheckQuiz")
public class CheckQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CheckQuiz() {
        super();
      
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
    	System.out.println("controller/CheckQuiz: Start");
    	String sujetQnaire = request.getParameter("Questionnaire sujet");
    	String login = request.getParameter("User login");
    	Timestamp btime = Timestamp.valueOf(request.getParameter("Course begin time"));
    	Timestamp etime =  Timestamp.valueOf(request.getParameter("Course end time"));
    	
    	System.out.println("controller/CheckQuiz: ");
    	System.out.println("controller/CheckQuiz: sujetQnaire="+ sujetQnaire);
    	System.out.println("controller/CheckQuiz: login="+ login);
    	System.out.println("controller/CheckQuiz: btime="+ String.valueOf(btime));
    	System.out.println("controller/CheckQuiz: etime="+ String.valueOf(etime));
    	
    	
    	User u = new User();
    	Course course = new Course();
    	ChoixQA choixqa = new ChoixQA();
    	Question qn = new Question();
    	Questionnaire qnaire = new Questionnaire();
    	qnaire.setSujet(sujetQnaire);
    	
    	CourseDAOImpl coursedao = new CourseDAOImpl();
    	QuestionDAOImpl qndao = new QuestionDAOImpl();
    	QQDAOImpl qqdao = new QQDAOImpl();
    	QADAOImpl qadao = new QADAOImpl();
    	
    	List<String> sujetQnlist= new ArrayList<String>();
    	sujetQnlist = qqdao.findAllQuestionForCourse(sujetQnaire);
    	long duration = 12;
    	
    	int random = (int)(1+Math.random()*(9999-1+1));
    	String id = String.valueOf(random);
    	System.out.println("controller/CheckQuiz: id="+id);
    	
    	HttpSession session = request.getSession();
    	u = (User) session.getAttribute("user");
    	System.out.println("controller/CheckQuiz: u = "+ u.toString());
    	
    	course.setSujetQnaire(sujetQnaire);
    	course.setID(id);
    	course.setLogin(login);
    	course.setBtime(btime);
    	course.setEtime(etime);
    	course.setDuration(duration);
    	
    	choixqa.setID(id);

    	int score = 0;
    	course.setScore(score);
    	coursedao.addCourse(course);
    	
    	for(String sujetQn : sujetQnlist) {
    		System.out.println("controller/CheckQuiz: sujetQn="+sujetQn);
    		qn = qndao.findBySujet(sujetQn);
    		if( qn.getStat().equals("actif")) {
    			choixqa.setSujetQ(sujetQn);
    			String choixA = request.getParameter(String.valueOf(sujetQn));
    			System.out.println("controller/CheckQuiz: choixA="+choixA);
    			choixqa.setSujetA(choixA);
    			boolean canswer = qadao.getCanswer(choixA);
    			if(canswer){
    				score +=1;
    			}
    			choixqa.setCanswer(canswer);
    			coursedao.addChoixqa(choixqa);
    		}
    	}
    	
//    	coursedao.updateScore(id, score);
    	
    	
    	
    	RequestDispatcher dispatcher = null;
    	if(coursedao.updateScore(id, score)) {
    		dispatcher = request.getRequestDispatcher("/jsp/result.jsp");
    	}else {
 			dispatcher = request.getRequestDispatcher("/jsp/error.jsp");
     	}
    	
    	dispatcher.forward(request, response);
    	System.out.println("controller/CheckQuiz: End");
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
