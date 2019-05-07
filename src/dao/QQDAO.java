package dao;

import java.sql.SQLException;
import java.util.List;

import model.Question;

public interface QQDAO {
	public List<Question> findAllQuestionBySujetQnaire(String sujetQnaire) throws SQLException;
	public boolean addQn(Question question) throws SQLException;
	public boolean deleteQn(String sujetQn) throws SQLException;
	public Integer getMaxOrder(String sujetQnaire)throws SQLException ;
}
