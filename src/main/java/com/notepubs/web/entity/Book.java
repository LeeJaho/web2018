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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity

//Table 이름이 다르다면 Mapping 해줘야하
//@Table(name="Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//기본 키를 직접 할당하기 위해서는 @Id 어노테이션만 사용하면 되고, 자동 생성 전략을 사용하기 위해서는 @Id에 @GeneratedValue를
	//추가하고 원하는 키 생성 전략을 선택하면 된다.
	private int id;
	private String title;
	private String coverImg;
	private String writerId;
	private Date regDate;
	private int hit;
	@Column(name="`order`") //order라는 명령어? 랑 겹쳐서
	private int order;
	
	
	
	public Book() {
		
	}

	
	
	public Book(String title, String coverImg, String writerId) {
		this.title = title;
		this.coverImg = coverImg;
		this.writerId = writerId;
	}



	public Book(int id, String title, String coverImg, String writerId, Date regDate, int hit, int order) {
		this.id = id;
		this.title = title;
		this.coverImg = coverImg;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;
		this.order = order;
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



	public String getCoverImg() {
		return coverImg;
	}



	public void setCoverImg(String coverImg) {
		this.coverImg = coverImg;
	}



	public String getWriterId() {
		return writerId;
	}



	public void setWriterId(String writerId) {
		this.writerId = writerId;
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



	public int getOrder() {
		return order;
	}



	public void setOder(int order) {
		this.order = order;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", coverImg=" + coverImg + ", writerId=" + writerId
				+ ", regDate=" + regDate + ", hit=" + hit + ", order=" + order + "]";
	}





	
	
	
	
}
