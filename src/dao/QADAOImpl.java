package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.QA;
import model.User;
import util.ConnSQL;

public class QADAOImpl implements QADAO {
	
	@Override
	public boolean addA(QA qa) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into qa values(?,?,?,?)";
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, qa.getSujetQ());
			ps.setString(2, qa.getSujetA());
			ps.setBoolean(3, qa.getCanswer());
			ps.setInt(4, qa.getOrder());
			
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
	public boolean deleteA(String sujetQ, String sujetA) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from qa where sujetA=? and sujetQ=?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sujetA);
			ps.setString(2, sujetQ);
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:DELETE");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
//	@Override
//	public boolean changeOrder(String sujetQ, String sujetA) throws SQLException{}
	
	@Override
	public  List<Answer> findAllAnswerBySujetQ(String sujetQ) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		Answer ans = null;
		List<Answer> Answers = new ArrayList<Answer>();
		String sql = "select * from qa where sujetQ=?"; 
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sujetQ);
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
	public Integer getMaxOrder(String sujetQ)throws SQLException {
		int maxorder = 0;
		String sql = "select * from qa where sujetQ = ?";
		Connection conn = null;
		PreparedStatement pstem = null;
		ResultSet res = null;
		try {
			conn = ConnSQL.getConnection();
		    pstem = conn.prepareStatement(sql);
		    pstem.setString(1, sujetQ);
			res = pstem.executeQuery();
			
			while(res.next()){
				if(res.getInt("orders")> maxorder) {
					maxorder = res.getInt("orders");
				}
			}
//			System.out.println("dao/QADAOImpl::getMaxOrder(): maxorder"+maxorder);
			return maxorder;
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("Echec:getMaxOrder");
		}finally{
			ConnSQL.close(null,pstem,conn);
		}
		
	}
	
	@Override
	public boolean getCanswer(String sujetA)throws SQLException{
		boolean canswer = false;
		String sql = "select * from qa where sujetA = ?";
		Connection conn = null;
		PreparedStatement pstem = null;
		ResultSet res = null;
		try {
			conn = ConnSQL.getConnection();
		    pstem = conn.prepareStatement(sql);
		    pstem.setString(1, sujetA);
			res = pstem.executeQuery();
			
			while(res.next()){
				canswer = res.getBoolean("canswer");	
			}
			return canswer;
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("Echec:getMaxOrder");
		}finally{
			ConnSQL.close(null,pstem,conn);
		}
	}
}
