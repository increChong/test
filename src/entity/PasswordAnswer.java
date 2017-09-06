package entity;

public class PasswordAnswer {
	private String squestion;
	private String sanswer;
	private String ubackupemail;
	private String answerid;
	private String userid;

	public PasswordAnswer(){}
	
	public PasswordAnswer(String squestion, String sanswer,
			String ubackupemail, String answerid, String userid) {
		super();
		this.squestion = squestion;
		this.sanswer = sanswer;
		this.ubackupemail = ubackupemail;
		this.answerid = answerid;
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSquestion() {
		return squestion;
	}
	public void setSquestion(String squestion) {
		this.squestion = squestion;
	}
	public String getSanswer() {
		return sanswer;
	}
	public void setSanswer(String sanswer) {
		this.sanswer = sanswer;
	}
	public String getUbackupemail() {
		return ubackupemail;
	}
	public void setUbackupemail(String ubackupemail) {
		this.ubackupemail = ubackupemail;
	}
	public String getAnswerid() {
		return answerid;
	}
	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}

}
