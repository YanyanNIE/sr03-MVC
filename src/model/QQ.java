package model;

public class QQ {
	private String sujetQn;
	private String sujetQnaire;
	private Integer order;
	
	public QQ(){
		
	}
	
	public QQ(String sujetQn, String sujetQnaire) {
		this.sujetQn = sujetQn;
		this.sujetQnaire = sujetQnaire;
	}
	
	// methods of get
	public String getSujetQn() {
		return sujetQn;
	}
	
	public String getSujetQnaire() {
		return sujetQnaire;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	// methods of set
	public void setSujetQn(String sujetQn) {
		this.sujetQn = sujetQn;
	}
	
	public void setSujetQnaire(String sujetQnaire) {
		this.sujetQnaire = sujetQnaire;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	// show
	public String toString() {
		return "QQ:("+"sujetQn ="+sujetQn+", sujetQnaire="+sujetQnaire+")";
	}
}
