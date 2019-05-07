package model;

import java.util.ArrayList;

public class Questionnaire {
	private String sujet;
	private String stat;
	
	public Questionnaire(){
		
	}
	
	public Questionnaire(String sujet, String stat) {
		this.sujet = sujet;
		this.stat = stat;
	}
	
	// methods of get
	public String getSujet() {
		return sujet;
	}
	
	public String getStat() {
		return stat;
	}
	
	// methods of set
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	
	public void setStatus(String stat) {
		this.stat = stat;
	}
	
	// show
	public String toString() {
		return "Answer:("+"sujet ="+sujet+", stat="+stat+")";
	}

}
