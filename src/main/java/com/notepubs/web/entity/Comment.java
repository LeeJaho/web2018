package com.notepubs.web.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.apache.ibatis.annotations.Many;

@Entity
public class Comment {
   
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private String content;
   private Date regDate;
   private String writerId;
   @Column(insertable=false, updatable=false)
   private int noteId;  //참조키 지우고 밑에 JoinColumn 추가 
   
   @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}/*, fetch=FetchType.EAGER*/)
   @JoinColumn(name="noteId")
   private Note note;
   

   
   public Comment(String content, String writerId, int noteId) {
      super();
      this.content = content;
      this.writerId = writerId;
      this.noteId = noteId;
   }





   public Comment(int id, String content, Date regDate, String writerId, int noteId) {
	super();
	this.id = id;
	this.content = content;
	this.regDate = regDate;
	this.writerId = writerId;
	this.noteId = noteId;
   }





   @Override
   public String toString() {
      return "Comment [id=" + id + ", content=" + content + ", regDate=" + regDate + ", writerId=" + writerId
           + "]";
   }





	   public int getNoteId() {
		return noteId;
	}





	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	
	
	
	
	
	public Note getNote() {
		return note;
	}
	
	
	
	
	
	public void setNote(Note note) {
		this.note = note;
	}




	
	public Comment() {
	      // TODO Auto-generated constructor stub
	   }


   public int getId() {
      return id;
   }


   public void setId(int id) {
      this.id = id;
   }


   public String getContent() {
      return content;
   }


   public void setContent(String content) {
      this.content = content;
   }


   public Date getRegDate() {
      return regDate;
   }


   public void setRegDate(Date regDate) {
      this.regDate = regDate;
   }


   public String getWriterId() {
      return writerId;
   }


   public void setWriterId(String writerId) {
      this.writerId = writerId;
   }


   
}