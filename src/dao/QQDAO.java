package dao;

import java.sql.SQLException;
import java.util.List;

import model.QQ;
import model.Question;

public interface QQDAO {
	public List<Question> findAllQuestionBySujetQnaire(String sujetQnaire) throws SQLException;
	public List<String> findAllQuestionForCourse(String sujetQnaire) throws SQLException;
	public boolean add(QQ qq) throws SQLException;
	public boolean deleteQn(String sujetQn, String sujetQnaire) throws SQLException;
	public Integer getMaxOrder(String sujetQnaire)throws SQLException ;
}
