package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.ChoixQA;
import model.Course;
import model.Questionnaire;
import model.User;
import util.ConnSQL;

public class CourseDAOImpl implements CourseDAO {
	@Override
	public List<Course> findAllCourse(String login) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Course crs = null;
		List<Course> Courses = new ArrayList<Course>();
		String sql = "select * from course where login=?"; 
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, login);
			res = ps.executeQuery(sql);
			
			while(res.next()){
				crs.setLogin(login);
				crs.setSujetQnaire(res.getString("sujetQnaire"));
				crs.setID(res.getString("id"));
				crs.setScore(res.getInt("score"));
				crs.setBtime(res.getTimestamp("btime"));
				crs.setEtime(res.getTimestamp("etime"));
				crs.setDuration(res.getInt("duration"));
				Courses.add(crs);
	        }
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:FINDALL");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }	
		return Courses;
	}
	
	@Override
	public boolean addChoixqa(ChoixQA choixqa) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into choixqa values(?,?,?,?)";
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, choixqa.getID() );
			ps.setString(2, choixqa.getSujetQ());
			ps.setString(3, choixqa.getSujetA());
			ps.setBoolean(4, choixqa.getCanswer());
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:ADD");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
	@Override
	public boolean addCourse(Course course) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into course values(?,?,?,?,?,?,?)";
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, course.getID() );
			ps.setString(2, course.getLogin());
			ps.setString(3, course.getSujetQnaire());
			ps.setInt(4, course.getScore());
			ps.setTimestamp(5, course.getBtime());
			ps.setTimestamp(6, course.getEtime());
			ps.setLong(7, course.getDuration());
			
			
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:ADD");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
	@Override
	public boolean updateScore(String id, int score) throws SQLException{
		System.out.println("dao/CourseDAOImpl::updateScore: Start ");
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE course SET scores = ? WHERE id = ?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, score);
			ps.executeUpdate();
			System.out.println("dao/CourseDAOImpl::updateScore: End ");
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec: updateScore");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
//	
//	@Override
//	public List<ChoixQA> findAllChoixQA(String id) throws SQLException{
//		
//	}
//	
//	@Override
//	public Integer calculScore(List<ChoixQA> lchoixqa) throws SQLException{
//		
//	}
//	
//	@Override
//	public Integer calculDuration(Timestamp btime, Timestamp etime) throws SQLException{
//		
//	}
}
