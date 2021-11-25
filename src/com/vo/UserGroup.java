package com.vo;

public class UserGroup {

	private String u_act;
	private String u_role;
	public String getU_act() {
		return u_act;
	}
	public void setU_act(String u_act) {
		this.u_act = u_act;
	}
	public String getU_role() {
		return u_role;
	}
	public void setU_role(String u_role) {
		this.u_role = u_role;
	}
	@Override
	public String toString() {
		return "UserGroup [u_act=" + u_act + ", u_role=" + u_role + "]";
	}
	public UserGroup(String u_act, String u_role) {
		super();
		this.u_act = u_act;
		this.u_role = u_role;
	}
	public UserGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
