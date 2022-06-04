package entity;
/**
 * 后台管理员信息类
 *
 */
public class Admin_UserInfo {
	private int admin_userId;
	private String admin_loginName;
	private String admin_loginPass;
	private String admin_Name;
	private String admin_gender;
	private String admin_tel;
	
	public int getAdmin_userId() {
		return admin_userId;
	}

    public void setAdmin_loginName(String adminLoginName) {
		admin_loginName = adminLoginName;
	}

    public String getAdmin_Name() {
		return admin_Name;
	}
	public void setAdmin_Name(String adminName) {
		admin_Name = adminName;
	}
}
