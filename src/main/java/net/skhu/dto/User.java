package net.skhu.dto;

//18.12.03 디비캡스톤 기말고사
//로그인할 때 사용할 사용자 객체
public class User {
	int userId;
	String password;
	String userType;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
