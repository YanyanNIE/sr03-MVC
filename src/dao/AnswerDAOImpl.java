package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Answer;
import util.ConnSQL;

public class AnswerDAOImpl implements AnswerDAO{
	public List<Answer> findAll() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Answer ans = null;
		List<Answer> Answers = new ArrayList<Answer>();
		String sql = "select * from answer"; 
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery(sql);
			
			while(res.next()){
				ans.setSujet(res.getString("sujet"));
		        ans.setStatus(res.getString("stat"));
	            Answers.add(ans);
	        }
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:FINDALL");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }	
		return Answers;
	}
	
	@Override
	public boolean add(Answer ans) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into answer values(?,?)";
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, ans.getSujet());
			ps.setString(2, ans.getStat());
			
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:ADD");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
	@Override
	public boolean delete(String sujet) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from answer where sujet=?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sujet);
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:DELETE");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
	@Override
	public boolean updateStat(String sujet,String stat) throws SQLException{
		System.out.println("dao/AnswerDAOImpl::updateStat: Start ");
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE answer SET stat = ? WHERE sujet = ?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stat);
			ps.setString(2, sujet);
			ps.executeUpdate();
			System.out.println("dao/AnswerDAOImpl::updateStat: End ");
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec: updateStat");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
	@Override
	public Answer findBySujet(String sujet) throws SQLException{
		Answer ans = new Answer();
		String sql = "select * from answer where sujet = ?";
		Connection conn = null;
		PreparedStatement pstem = null;
		ResultSet res = null;
		try {
				
			conn = ConnSQL.getConnection();
		    pstem = conn.prepareStatement(sql);
		    pstem.setString(1, sujet);
			res = pstem.executeQuery();
			System.out.println("UserDAOImpl.findByLogin()");
			if(res.next()){
				ans.setSujet(res.getString("sujet"));
				ans.setStatus(res.getString("stat"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("Echec:DELETE");
		}finally{
			ConnSQL.close(null,pstem,conn);
		}
		
    	ConnSQL.close(res,pstem,conn);
		return ans;
	}

}
