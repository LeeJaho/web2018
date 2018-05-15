package com.notepubs.web.entity;

import javax.persistence.Entity;

@Entity
public class NoteView extends AbstractNote{
	private int commentCount;
	private String writerId;
	
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	
	
}
