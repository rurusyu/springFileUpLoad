package org.zerock.domain;



public class MemberVO {

	private String uid, upw, uname;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String toString() {
		return "MemberVO [uid=" + uid + ", upw=" + upw + ", uname=" + uname + "]";
	}


	
	
}
