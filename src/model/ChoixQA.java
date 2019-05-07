package model;

public class ChoixQA {
	private String id;
	private String sujetQ;
	private String sujetA;
	private Boolean canswer;
	
	public ChoixQA(){
		
	}
	
	public ChoixQA(String id, String sujetQ, String sujetA, Boolean canswer) {
		this.id = id;
		this.sujetQ = sujetQ;
		this.sujetA = sujetA;
		this.canswer = canswer;
	}
	
	// methods of get
	public String getID() {
		return id;
	}
	
	public String getSujetQ() {
		return sujetQ;
	}
	
	public String getSujetA() {
		return sujetA;
	}
	
	public Boolean getCanswer() {
		return canswer;
	}
	
	// methods of set
	public void setID(String id) {
		this.id = id;
	}
	
	public void setSujetQ(String sujetQ) {
		this.sujetQ = sujetQ;
	}
	
	public void setSujetQnaire(String sujetA) {
		this.sujetA = sujetA;
	}
	
	public void setCanswer(Boolean canswer) {
		this.canswer = canswer;
	}
	// show
	public String toString() {
		return "QQ:("+ "id="+ id +", sujetQ ="+sujetQ+", sujetA="+ sujetA  + "canswer="+ canswer + ")";
	}
}
