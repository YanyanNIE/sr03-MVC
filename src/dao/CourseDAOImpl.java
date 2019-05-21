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
import util.ConnSQL;

public class CourseDAOImpl implements CourseDAO {
	@Override
	public List<Course> findAll(String login) throws SQLException{
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
	
//	@Override
//	public boolean add(Questionnaire questionnaire) throws SQLException{
//		
//	}
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
