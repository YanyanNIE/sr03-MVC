package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ConnSQL {
	public static String URL;
	public static String USERNAME;
	public static String PASSWORD;
	public static String DRIVER;
	private static ResourceBundle rb = ResourceBundle.getBundle("util.dbConfig");
	    
    private ConnSQL(){}
    
    //bind data
    static{
    	//System.out.println("test");
        URL = rb.getString("jdbc.url");
        USERNAME = rb.getString("jdbc.username");
        PASSWORD = rb.getString("jdbc.password");
        DRIVER = rb.getString("jdbc.driver");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //connection
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fail:connexion!");
        }
        return conn;
    }
    
    //disconnection
    public static void close(ResultSet rs,Statement stat,Connection conn){
            try {
                if(rs!=null)rs.close();
                if(stat!=null)stat.close();
                if(conn!=null)conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    
    //main:test
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
    
    		Connection conn = getConnection();
			
    		java.sql.Statement stem =  conn.createStatement();
    		ResultSet res = stem.executeQuery("select * from users;");
    		while(res.next()){
    			String login  = res.getString("login");
                String profil = res.getString("profil");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
    
                System.out.print("\nlogin:" + login);
                System.out.print(", profil: " + profil);
                System.out.print(", nom: " + nom);
                System.out.print(", prenom: " + prenom);
                System.out.print("\n");
            }
    		close(res,stem,conn);
    	
    }
	  


}
