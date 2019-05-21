package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import model.User;
import util.ConnSQL;

public class UserDAOImpl implements UserDAO{

	@Override
	public List<User> findAll() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		User u = null;
		List<User> Users = new ArrayList<User>();
		String sql = "select * from users";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			res = ps.executeQuery(sql);
			
			while(res.next()){
				u.setLogin(res.getString("login"));
		        u.setPwd(res.getString("pwd"));
		        u.setFname(res.getString("fname"));
		        u.setLname(res.getString("lname"));
		        u.setIdentity(res.getString("ident"));
		        u.setSociety(res.getString("society"));
		        u.setPhone(res.getString("phone"));
		        u.setCdate(res.getDate("cdate"));
		        u.setStat(res.getString("stat"));
	            Users.add(u);
	        }
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec:findAll");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
		return Users;
	}
	
	@Override
	public boolean add(User u) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into users values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getFname());
			ps.setString(4, u.getLname());
			ps.setString(5, u.getIndentity());
			ps.setString(6, u.getSociety());
			ps.setString(7, u.getPhone());
			ps.setDate(8, u.getCdate());
			ps.setString(9, u.getStat());
			
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
	public boolean delete(String login) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from users where login=?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, login);
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
	public boolean updateStat(String login, String stat) throws SQLException{
		System.out.println("dao/UserDAOImpl::updateStat: Start ");
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE users SET stat = ? WHERE login = ?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stat);
			ps.setString(2, login);
			ps.executeUpdate();
			System.out.println("dao/UserDAOImpl::updateStat: End ");
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec: updateStat");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
		
	}
	
	@Override
	public boolean updateProfile(User u) throws SQLException{
		System.out.println("dao/UserDAOImpl::updateProfile: Start ");
		Connection conn = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE users SET pwd=?, fname=?, lname=?, ident=?, society=?, phone=?, stat=? WHERE login=?";
		
		try {
			conn = ConnSQL.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getPwd());
			ps.setString(2, u.getFname());
			ps.setString(3, u.getLname());
			ps.setString(4, u.getIndentity());
			ps.setString(5, u.getSociety());
			ps.setString(6, u.getPhone());
			ps.setString(7, u.getStat());
			ps.setString(8, u.getLogin());
			System.out.println("dao/UserDAOImpl::updateProfile: ps ="+ps);
			ps.executeUpdate();
			System.out.println("dao/UserDAOImpl::updateProfile: End ");
			return true;
		}catch(SQLException e){
          e.printStackTrace();
             throw new SQLException("Echec: updateProfile");
        }finally{
        	ConnSQL.close(null,ps,conn);
        }
	}
	
	@Override
	public User findByLogin(String login) throws SQLException{
		User u = new User();
		String sql = "select * from users where login = ?";
		Connection conn = null;
		PreparedStatement pstem = null;
		ResultSet res = null;
		try {
				
			conn = ConnSQL.getConnection();
		    pstem = conn.prepareStatement(sql);
		    pstem.setString(1, login);
			res = pstem.executeQuery();
			System.out.println("UserDAOImpl.findByLogin()");
			if(res.next()){
				u.setLogin(res.getString("login"));
		        u.setPwd(res.getString("pwd"));
		        u.setFname(res.getString("fname"));
		        u.setLname(res.getString("lname"));
		        u.setIdentity(res.getString("ident"));
		        u.setSociety(res.getString("society"));
		        u.setPhone(res.getString("phone"));
		        u.setCdate(res.getDate("cdate"));
		        u.setStat(res.getString("stat"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("Echec:findByLogin");
		}finally{
			ConnSQL.close(null,pstem,conn);
		}
		
    	ConnSQL.close(res,pstem,conn);
		return u;
		
	}


}
