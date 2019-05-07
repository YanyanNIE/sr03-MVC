package dao;

import java.sql.SQLException;
import java.util.List;

import  model.Answer;

public interface AnswerDAO {
	public List<Answer> findAll() throws SQLException;
	public boolean add(Answer answer) throws SQLException;
	public boolean delete(String sujet) throws SQLException;
	public boolean update(String sujet) throws SQLException;
	public Answer findBySujet(String sujet) throws SQLException;

}
