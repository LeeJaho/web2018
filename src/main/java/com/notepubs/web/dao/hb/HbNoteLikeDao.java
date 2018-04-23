package com.notepubs.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.NoteLikeDao;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteLike;

@Repository
public class HbNoteLikeDao implements NoteLikeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public NoteLike get(Integer noteId, String memberId) {
		//session 팩토리에서 꺼내오기!
		Session session = sessionFactory.getCurrentSession();
		
		NoteLike noteLike = session.get(NoteLike.class, new NoteLike(noteId, memberId));
		return noteLike;
	}

	@Transactional
	@Override
	public int insert(NoteLike noteLike) {
		Session session = sessionFactory.getCurrentSession();
		session.save(noteLike);
		
		return 0;

	}
	
	@Transactional
	@Override
	public int delete(NoteLike noteLike) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(noteLike);
		
		return 0;

	}

}
