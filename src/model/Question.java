package model;

public class Question {
	private String sujet;
	private String stat;
	
	public Question() {
		
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
			return "Question:("+"sujet ="+sujet+", stat="+stat+")";
		}

}
