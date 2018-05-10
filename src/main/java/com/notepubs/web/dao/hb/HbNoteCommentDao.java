package com.notepubs.web.dao.hb;

import java.util.List;

import org.hibernate.query.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.NoteCommentDao;
import com.notepubs.web.entity.NoteComment;


@Repository
public class HbNoteCommentDao implements NoteCommentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public int insert(NoteComment comment) {
		
		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(comment);
		
		int result = 0;
		if(id > 0)
			result = 1;
		
		return result;
	}

	/*@Transactional
	@Override
	public List<NoteComment> getList(Integer page) {

		Session session = sessionFactory.getCurrentSession();
		Query<NoteComment> query = session.createQuery("from NoteComment", NoteComment.class);
		List<NoteComment> list = query.getResultList();
		
		return list;
	}
*/
}
