package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Question;
import util.ConnSQL;

public class QuestionDAOImpl implements QuestionDAO {
	@SuppressWarnings("null")
	@Override
	public List<Question> findAll() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Question ques = null;
		List<Question> Questions= new ArrayList<Question>();
		String sql = "select * from question"; 
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery(sql);
			
			while(res.next()){
				ques.setSujet(res.getString("sujet"));
				ques.setStatus(res.getString("stat"));
				Questions.add(ques);
	        }
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:findAll");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }	
		return Questions;
	}
	
	@Override
	public boolean add(Question ques) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into question values(?,?)";
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, ques.getSujet());
			ps.setString(2, ques.getStat());
			
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:add");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
	@Override
	public boolean delete(String sujet) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from question where sujet=?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sujet);
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:delete");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
//	@Override
//	public boolean update(String sujet) throws SQLException{}
	
	@Override
	public Question findBySujet(String sujet) throws SQLException{
		Question ques = new Question();
		String sql = "select * from question where sujet = ?";
		Connection conn = null;
		PreparedStatement pstem = null;
		ResultSet res = null;
		try {
				
			conn = ConnSQL.getConnection();
		    pstem = conn.prepareStatement(sql);
		    pstem.setString(1, sujet);
			res = pstem.executeQuery();
			System.out.println("QuestionDAOImpl.findBySujet()");
			if(res.next()){
				ques.setSujet(res.getString("sujet"));
				ques.setStatus(res.getString("stat"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("Echec:findBySujet");
		}finally{
			ConnSQL.close(null,pstem,conn);
		}
		
    	ConnSQL.close(res,pstem,conn);
		return ques;
		
	}


}
