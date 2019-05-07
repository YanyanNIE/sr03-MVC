package model;

public class QA {
	private String sujetQ;
	private String sujetA;
	private Integer order;
	private Boolean canswer;
	
	public QA(){
		
	}
	
	public QA(String sujetQ, String sujetA, Integer order, Boolean canswer) {
		this.sujetQ = sujetQ;
		this.sujetA = sujetA;
		this.order = order;
		this.canswer = canswer;
	}
	
	// methods of get
	public String getSujetQ() {
		return sujetQ;
	}
	
	public String getSujetA() {
		return sujetA;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	public Boolean getCanswer() {
		return canswer;
	}
	
	// methods of set
	public void setSujetQ(String sujetQ) {
		this.sujetQ = sujetQ;
	}
	
	public void setSujetQnaire(String sujetA) {
		this.sujetA = sujetA;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public void setCanswer(Boolean canswer) {
		this.canswer = canswer;
	}
	// show
	public String toString() {
		return "QQ:("+"sujetQ ="+sujetQ+", sujetA="+sujetA+ ", order="+ order + "canswer="+ canswer + ")";
	}
}
