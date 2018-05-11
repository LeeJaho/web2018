package com.notepubs.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.NoteCommentDao;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteComment;


@Repository
public class HbNoteCommentDao implements NoteCommentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public int insert(NoteComment comment) {
		
		Session session = sessionFactory.getCurrentSession();
		
		//System.out.println(comment.getNoteId());
		Note note = new Note(comment.getNoteId());
		comment.setNote(note);
		
		int id = (int) session.save(comment);
		
		int result = 0;
		if(id > 0)
			result = 1;
		
		return result;
	}
	
	@Transactional
	@Override
	public List<NoteComment> getListByNote(Integer page, Integer noteId) {
		
		//System.out.println(noteId);
		//NoteComment noteComment = new NoteComment();
		//noteComment.setNoteId(noteId);
		
		Session session = sessionFactory.getCurrentSession();
		Query<NoteComment> query 
			= session
				.createQuery("from NoteComment where noteId=:noteId order by regDate desc", NoteComment.class)
				.setParameter("noteId", noteId);
		
		List<NoteComment> list = query.getResultList();
		return list;
	}

	
}
