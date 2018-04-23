package com.notepubs.web.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NoteLike implements Serializable {
	
	@Id
	private int noteId;
	@Id
	private String memberId;
	private Date regDate;
	
	@ManyToOne //부모를 join해준다
	private Member member;
	
	public NoteLike() {
		// TODO Auto-generated constructor stub
	}

	public NoteLike(int noteId, String memberId) {
		super();
		this.noteId = noteId;
		this.memberId = memberId;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
		
}
