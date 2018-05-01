package com.notepubs.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteView;




@Repository//Dao라는 의미?
public class HbNoteDao implements NoteDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<NoteView> getList(Integer page) {
		
		//session 팩토리에서 꺼내오기!
		Session session = sessionFactory.getCurrentSession();
		Query<NoteView> query = session.createQuery("from NoteView", NoteView.class);
		List<NoteView> list = query.getResultList();
		
		return list;
	}
	
	@Transactional
	@Override
	public NoteView get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		NoteView note = session.get(NoteView.class, id);
		
		return note;
	}
	
	@Transactional
	@Override
	public int insert(Note note) {
		
		return 0;
	}
	
	@Transactional
	@Override
	public NoteView getPrevNote(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteView> query = session.createQuery("from NoteView " + 
				"where regDate < (select regDate from NoteView where id=:id) " + 
				"order by regDate desc", NoteView.class)
				.setParameter("id", id)
				.setMaxResults(1);
		
		NoteView note = query.getSingleResult();
		//NoteView prevNote = session.get(NoteView.class, id);
		return note;
	}
	
	@Transactional
	@Override
	public NoteView getNextNote(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<NoteView> query = session.createQuery("from NoteView " + 
				"where regDate > (select regDate from NoteView where id=:id) " + 
				"order by regDate", NoteView.class)
				.setParameter("id", id)
				.setMaxResults(1);
		
		NoteView note = query.getSingleResult();
		return note;
	}

}
