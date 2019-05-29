package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import model.Course;
import model.Questionnaire;
import model.User;
import model.ChoixQA;

public interface CourseDAO {
	public List<Course> findAllCourse(String login) throws SQLException;
	public boolean addChoixqa(ChoixQA choixqa) throws SQLException;
	public boolean addCourse(Course course) throws SQLException;
	public boolean updateScore(String id, int score) throws SQLException;
//	public List<ChoixQA> findAllChoixQA(String id) throws SQLException;
//	public Integer calculScore(List<ChoixQA> lchoixqa) throws SQLException;
//	public Integer calculDuration(Timestamp btime, Timestamp etime) throws SQLException;

}
