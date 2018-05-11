package com.notepubs.web.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Note {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //테이블이 알아서 하나씩 +1 올려준다?
	private int id;
	private String title;
	private String content;	
	private Date regDate;
	private int hit;
	@Column(name="`order`")
	private int order;
	private boolean pub;
	
	//CRUD 가능해야 하니까 Note에다 놓는다
	@OneToMany(mappedBy="note", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private /*List<Comment>*/List<NoteComment> comments;

	
	
	
	
	public List<NoteComment> getComments() {
		return comments;
	}

	public void setComments(List<NoteComment> comments) {
		this.comments = comments;
	}
	
	@Transient //hibernate에서 만들 필요 없고 내가 담아줄 것들이라는 선언
	private Note prevNote;
	@Transient
	private Note nextNote;
	
	
	public void setPrevNote(Note prevNote) {
		this.prevNote = prevNote;
	}
	
	public void setNextNote(Note nextNote) {
		this.nextNote = nextNote;
	}
	
	public Note getPrevNote() {
		return prevNote;
	}

	
	public Note getNextNote() {
		return nextNote;
	}

	


	public Note() {
		
	}

	

	public Note(String title, String content) {		
		this.title = title;
		this.content = content;		
	}
	


	public Note(int id, String title, String content, Date regDate, int hit, int order, boolean pub) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.order = order;
		this.pub = pub;
	}

	
	public Note(int noteId) {
		this.id = noteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	public boolean isPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", hit=" + hit
				+ ", order=" + order + ", pub=" + pub + "]";
	}

	
	
	
	
}