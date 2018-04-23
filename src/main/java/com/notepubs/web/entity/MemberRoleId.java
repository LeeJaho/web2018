package com.notepubs.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//Table과 직접적으로 연결되는 클래스는 아니고
//엔티티 안에 따로 일부 키를 따로 클래스로 구현 한 녀석이다
@Embeddable
public class MemberRoleId implements Serializable {
	//@Column("MEMBER_ID") //만약 DB 속성 이름이랑 일치하지 않는다면 이렇게 맞춰줘야하는데
						//우린 맞춰줬으니 안써도 됨
	private String memberId; //-> MEMBER_ID
	private String roleId;
	
	public MemberRoleId() {
		
	}

	public MemberRoleId(String memberId, String roleId) {
		this.memberId = memberId;
		this.roleId = roleId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "MemberRoleId [memberId=" + memberId + ", roleId=" + roleId + "]";
	}
	
	
}
