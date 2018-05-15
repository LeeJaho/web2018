package com.notepubs.web.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
//enitity와 테이블명 다르다면 @Table("name="CMT")
public class NoteComment {
	
	@Id
	//컬럼 이름과 다르다면 @Column(name="memberId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/*@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinColumn(name="noteId")*/
	//참조키와 관련된 enitity를 객체로 만들어준다
	@Transient
	private Note note;
	
	//@Column(insertable=false, updatable=false) //insert, update 신경쓰지마라?
	private int noteId;
	
	private String nicName;
	private String pwd;
	private String content;
	
	@Column(insertable=false)//insert할 때 빼줘라 / DB에서 지정한 기본값으로 들어가라	
	private Date regDate;
	private boolean secret;
	
	public NoteComment() {
		// TODO Auto-generated constructor stub
	}

	//for insert
	public NoteComment(int noteId, String nicName, String pwd, String content, boolean secret) {
		
		this.noteId = noteId;
		this.nicName = nicName;
		this.pwd = pwd;
		this.content = content;
		this.secret = secret;
	}
	
	//for select
	public NoteComment(int id, int noteId, String nicName, String pwd, String content, Date regDate, boolean secret) {
		super();
		this.id = id;
		this.noteId = noteId;
		this.nicName = nicName;
		this.pwd = pwd;
		this.content = content;
		this.regDate = regDate;
		this.secret = secret;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNicName() {
		return nicName;
	}

	public void setNicName(String nicName) {
		this.nicName = nicName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public boolean isSecret() {
		return secret;
	}

	public void setSecret(boolean secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "NoteComment [id=" + id + ", noteId=" + noteId + ", nicName=" + nicName + ", pwd=" + pwd + ", content="
				+ content + ", regDate=" + regDate + ", secret=" + secret + "]";
	}
	
	
}
