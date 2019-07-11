package vo;

public class LoginVO {
	private String user_id;
	private String passwd;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String toString() {
		return "LoginVO [user_id=" + user_id + ",  passwd=" + passwd + "]";
	}
}
