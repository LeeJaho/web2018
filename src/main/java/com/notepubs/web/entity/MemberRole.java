package com.notepubs.web.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberRole {
	
	//복합키일 땐 이렇게 하면 안됨
	/*@Id
	private String memberId;
	@Id
	private String roleId;*/
	
	@EmbeddedId
	MemberRoleId memberRoleId;
	
	private String regAdmin;
	private Date regDate;
	private boolean defaultRole;
	
	public MemberRole() {
		// TODO Auto-generated constructor stub
	}
	
	//insert? update
	public MemberRole(String memberId, String roleId, String regAdmin) {
		
		//구조만 Embedded로 바뀌었으니 꽂아쓰는 형식으로 바꿈
		this.memberRoleId.setMemberId(memberId);
		this.memberRoleId.setRoleId(roleId);
		this.regAdmin = regAdmin;
	}

	//select
	public MemberRole(String memberId, String roleId, String regAdmin, Date regDate, boolean defaultRole) {
		this.memberRoleId.setMemberId(memberId);
		this.memberRoleId.setRoleId(roleId);
		this.regAdmin = regAdmin;
		this.regDate = regDate;
		this.defaultRole = defaultRole;
	}

	
	//getter setter
	public String getMemberId() {
		return memberRoleId.getMemberId();
	}


	public void setMemberId(String memberId) {
		this.memberRoleId.setMemberId(memberId);
	}


	public String getRoleId() {
		return memberRoleId.getRoleId();
	}


	public void setRoleId(String roleId) {
		this.memberRoleId.setRoleId(roleId);
	}


	public String getRegAdmin() {
		return regAdmin;
	}


	public void setRegAdmin(String regAdmin) {
		this.regAdmin = regAdmin;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public boolean isDefaultRole() {
		return defaultRole;
	}


	public void setDefaultRole(boolean defaultRole) {
		this.defaultRole = defaultRole;
	}

	
	public MemberRoleId getMemberRoleId() {
		return memberRoleId;
	}

	public void setMemberRoleId(MemberRoleId memberRoleId) {
		this.memberRoleId = memberRoleId;
	}

	@Override
	public String toString() {
		return "MemberRole [memberId=" + getMemberId() + ", roleId=" + getRoleId() + ", regAdmin=" + regAdmin + ", regDate="
				+ regDate + ", defaultRole=" + defaultRole + "]";
	}
	
	
	
	/*SELECT `MemberRole`.`memberId`,
    `MemberRole`.`roleId`,
    `MemberRole`.`regAdmin`,
    `MemberRole`.`regDate`,
    `MemberRole`.`defaultRole`
FROM `notepubsdb`.`MemberRole`;*/

}
