package dao;

import java.sql.SQLException;
import java.util.List;

import model.Questionnaire;

public interface QuestionnaireDAO {
	public List<Questionnaire> findAll() throws SQLException;
	public boolean add(Questionnaire questionnaire) throws SQLException;
	public boolean delete(String sujet) throws SQLException;
	public boolean update(String sujet) throws SQLException;
	public Questionnaire findBySujet(String sujet) throws SQLException;

}
