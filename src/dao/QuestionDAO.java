package dao;

import java.sql.SQLException;
import java.util.List;

import model.Question;

public interface QuestionDAO {
	public List<Question> findAll() throws SQLException;
	public boolean add(Question ques) throws SQLException;
	public boolean delete(String sujet) throws SQLException;
//	public boolean update(String sujet) throws SQLException;
	public Question findBySujet(String sujet) throws SQLException;


}
