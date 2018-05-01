package com.notepubs.web.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.notepubs.web.entity.Note;

@Entity
public class NoteView extends Note{
	
	@Column(insertable=false, updatable=false)
	private int commentCount;
	
	@Transient //hibernate에서 만들 필요 없고 내가 담아줄 것들이라는 선언
	private NoteView prevNote;
	@Transient
	private NoteView nextNote;
	
	
	public NoteView getPrevNote() {
		return prevNote;
	}

	public void setPrevNote(NoteView prevNote) {
		this.prevNote = prevNote;
	}

	public NoteView getNextNote() {
		return nextNote;
	}

	public void setNextNote(NoteView nextNote) {
		this.nextNote = nextNote;
	}

	public NoteView() {
		// TODO Auto-generated constructor stub
	}

	public NoteView(int id, String title, String content, Date regDate, int hit, boolean pub, int commentCount) {
		this.commentCount = commentCount;
	}
	
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	@Override
	public String toString() {
		return "NoteView [note="+super.toString()+", commentCount=" + commentCount + "]";
	}	
}