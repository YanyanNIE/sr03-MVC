package dao;

import java.sql.SQLException;
import java.util.List;

import model.User;

public interface UserDAO {
	
	public List<User> findAll() throws SQLException;
	public boolean add(User u) throws SQLException;
	public boolean updateStat(String login, String stat) throws SQLException;
	public boolean updateProfile(User u) throws SQLException;
	public boolean delete(String login) throws SQLException;
	public User findByLogin(String login) throws SQLException;
 }
