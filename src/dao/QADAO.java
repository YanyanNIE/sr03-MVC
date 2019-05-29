package dao;

import java.sql.SQLException;
import java.util.List;

import model.Answer;
import model.QA;

public interface QADAO {
	public boolean addA(QA qa) throws SQLException;
	public boolean deleteA(String sujetQ, String sujetA) throws SQLException;
//	public boolean changeOrder(String sujetQ, String sujetA) throws SQLException;
	public  List<Answer> findAllAnswerBySujetQ(String sujetQ) throws SQLException;
	public Integer getMaxOrder(String sujetQ)throws SQLException ;
	public boolean getCanswer(String sujetA)throws SQLException ;

}
