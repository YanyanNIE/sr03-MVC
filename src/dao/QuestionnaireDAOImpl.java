package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Question;
import model.Questionnaire;
import util.ConnSQL;

public class QuestionnaireDAOImpl implements QuestionnaireDAO {
	@SuppressWarnings("null")
	@Override
	public List<Questionnaire> findAll() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Questionnaire quesnaire = null;
		List<Questionnaire> Questionnaires= new ArrayList<Questionnaire>();
		String sql = "select * from questionnaire"; 
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery(sql);
			
			while(res.next()){
				quesnaire.setSujet(res.getString("sujet"));
				quesnaire.setStatus(res.getString("stat"));
				Questionnaires.add(quesnaire);
	        }
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:findAll");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }	
		return Questionnaires;
	}
	
	@Override
	public boolean add(Questionnaire quesnaire) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into questionnaire values(?,?)";
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, quesnaire.getSujet());
			ps.setString(2, quesnaire.getStat());
			
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
		String sql = "delete from questionnaire where sujet=?";
		
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
	public Questionnaire findBySujet(String sujet) throws SQLException{
		Questionnaire quesnaire = new Questionnaire();
		String sql = "select * from questionnaire where sujet = ?";
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
				quesnaire.setSujet(res.getString("sujet"));
				quesnaire.setStatus(res.getString("stat"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("Echec:findBySujet");
		}finally{
			ConnSQL.close(null,pstem,conn);
		}
		
    	ConnSQL.close(res,pstem,conn);
		return quesnaire;
	}

}
