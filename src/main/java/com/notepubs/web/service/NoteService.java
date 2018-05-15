package com.notepubs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteCommentDao;
import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.dao.NoteLikeDao;
import com.notepubs.web.entity.Comment;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteComment;
import com.notepubs.web.entity.NoteLike;
import com.notepubs.web.entity.NoteView;



@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;
	
	@Autowired
	private NoteCommentDao noteCommentDao;
	
	public List<NoteView> getNoteList(Integer page) {
		
		//noteDao = new ?();
		List<NoteView> list = noteDao.getList(page);
		return list;
	}

	public NoteView getNote(Integer id) {
		
		NoteView note = noteDao.get(id);
		Note prevNote = noteDao.getPrevNote(id);
		Note nextNote = noteDao.getNextNote(id);
		List<NoteComment> comments = noteCommentDao.getListByNote(1, id);
		note.setPrevNote(prevNote);
		note.setNextNote(nextNote);
		note.setComments(comments);
		return note;
	}

	public void setNoteLike(Integer noteId, String memberId) {
		
		NoteLike noteLike = noteLikeDao.get(noteId, memberId);
		
		if(noteLike == null)
			noteLikeDao.insert(new NoteLike(noteId, memberId));
		else
			noteLikeDao.delete(noteLike);
		
	}

	public int addComment(NoteComment comment) {
		
		int result = noteCommentDao.insert(comment);
		return result;
	}

	public List<NoteComment> getNoteCommentListByNote(Integer page, Integer noteId) {
		
		List<NoteComment> list = noteCommentDao.getListByNote(page, noteId);
		
		for(NoteComment n : list)
			n.setNote(null);
		
		return list;
	}
	
}
