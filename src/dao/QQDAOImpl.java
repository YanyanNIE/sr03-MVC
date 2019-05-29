package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.QQ;
import model.Question;
import util.ConnSQL;

public class QQDAOImpl implements QQDAO{
	private Question ques;

	@SuppressWarnings("null")
	@Override
	public List<Question> findAllQuestionBySujetQnaire(String sujetQnaire) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Question ques = null;
		List<Question> Questions= new ArrayList<Question>();
		String sql = "select * from qq where sujetQnaire=?"; 
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sujetQnaire);
			res = ps.executeQuery();
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
	public List<String> findAllQuestionForCourse(String sujetQnaire) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		ques = null;
		List<String> Questions= new ArrayList<String>();
		String sql = "select * from qq where sujetQnaire=?"; 
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sujetQnaire);
			res = ps.executeQuery();
			while(res.next()){
				System.out.println("QQDAO/findAllQuestionForCourse: sujetQn="+res.getString("sujetQn"));
				Questions.add(res.getString("sujetQn"));
	        }
			return Questions;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:findAll");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }	
		
	}
	
	
	@Override
	public boolean add(QQ qq) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into qq values(?,?,?)";
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, qq.getSujetQn());
			ps.setString(2, qq.getSujetQnaire());
			ps.setInt(3, qq.getOrder());
			
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
	public boolean deleteQn(String sujetQn, String sujetQnaire ) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from qq where sujetQn=? and sujetQnaire=?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sujetQn);
			ps.setString(2, sujetQnaire);
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:delete");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
	@Override
	public Integer getMaxOrder(String sujetQnaire)throws SQLException {
		int maxorder = 0;
		String sql = "select * from qq where sujetQnaire = ?";
		Connection conn = null;
		PreparedStatement pstem = null;
		ResultSet res = null;
		try {
				
			conn = ConnSQL.getConnection();
		    pstem = conn.prepareStatement(sql);
		    pstem.setString(1, sujetQnaire);
			res = pstem.executeQuery();
			while(res.next()){
				if(res.getInt("orders")>maxorder) {
					maxorder = res.getInt("orders");
				}
			}
			return maxorder;
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("Echec:getMaxOrder");
		}finally{
			ConnSQL.close(null,pstem,conn);
		}
		
	}
}
