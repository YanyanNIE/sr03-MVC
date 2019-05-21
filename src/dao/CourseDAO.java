package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import model.Course;
import model.Questionnaire;
import model.ChoixQA;

public interface CourseDAO {
	public List<Course> findAll(String login) throws SQLException;
//	public boolean add(Questionnaire questionnaire) throws SQLException;
//	public List<ChoixQA> findAllChoixQA(String id) throws SQLException;
//	public Integer calculScore(List<ChoixQA> lchoixqa) throws SQLException;
//	public Integer calculDuration(Timestamp btime, Timestamp etime) throws SQLException;

}
