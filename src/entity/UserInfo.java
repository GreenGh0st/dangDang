package entity;

public class UserInfo {
	/**
	 * 用户信息类
	 *
	 */
	private int userId;
	private String userName;
	private String userPwd;
	private String name;
	private String sex;	
	private String email;
	private String tel;
	private String address;
	private int userZt;
	
	public int getUserZt() {
		return userZt;
	}
	public void setUserZt(int userZt) {
		this.userZt = userZt;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserpwd(String userpwd) {
		this.userPwd = userpwd;
	}
	public String getUserSex() {
		return sex;
	}
	public void setUserSex(String usersex) {
		this.sex = usersex;
	}
	public String getName() {
		return name;
	}
	public void setName(String namexm) {
		this.name = namexm;
	}
	public String getUserEmail() {
		return email;
	}
	public void setUserEmail(String userEmail) {
		this.email = userEmail;
	}
	public String getUserTel() {
		return tel;
	}
	public void setUserTel(String userTel) {
		this.tel = userTel;
	}
	public void setUserAddr(String userAddr) {
		this.address = userAddr;
	}
	public String getUserAddr() {
		return address;
	}
}