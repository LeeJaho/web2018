package com.notepubs.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.entity.Note;




@Repository//Dao라는 의미?
public class HbNoteDao implements NoteDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Note> getList(Integer page) {
		
		//session 팩토리에서 꺼내오기!
		Session session = sessionFactory.getCurrentSession();
		Query<Note> query = session.createQuery("from Note");
		List<Note> list = query.getResultList();
		
		return list;
	}
	
	@Transactional
	@Override
	public Note get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Note note = session.get(Note.class, id);
		
		return note;
	}
	
	@Transactional
	@Override
	public int insert(Note note) {
		
		return 0;
	}

}
