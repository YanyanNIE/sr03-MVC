package model;

import java.sql.Timestamp;

public class Course {
	private String id;
	private String login;
	private String sujetQnaire;
	private Integer score = 0;
	private Timestamp btime;
	private Timestamp etime;
	private Integer duration = 0;
	
	public Course(){
		
	}
	
	public Course(String id, String login, String sujetQnaire, Timestamp btime, Timestamp etime ) {
		this.id = id;
		this.login = login;
		this.sujetQnaire = sujetQnaire;
		this.btime = btime;
		this.etime = etime;
	}
	
	// methods of get
	public String getID() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getSujetQnaire() {
		return sujetQnaire;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public Timestamp getBtime() {
		return btime;
	}
	
	public Timestamp getEtime() {
		return etime;
	}
	
	public Integer getDuration() {
		return duration;
	}
	
	// methods of set
	public void setID(String id) {
		this.id = id;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setSujetQnaire(String sujetQnaire) {
		this.sujetQnaire = sujetQnaire;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public void setBtime(Timestamp btime) {
		this.btime = btime;
	}
	
	public void setEtime(Timestamp etime) {
		this.etime = etime;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
