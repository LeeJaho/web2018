package com.notepubs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteCommentDao;
import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.dao.NoteLikeDao;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteComment;
import com.notepubs.web.entity.NoteLike;



@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;
	
	@Autowired
	private NoteCommentDao noteCommentDao;
	
	public List<Note> getNoteList(Integer page) {
		
		//noteDao = new ?();
		List<Note> list = noteDao.getList(page);
		return list;
	}

	public Note getNote(Integer id) {
		
		Note note = noteDao.get(id);
		Note prevNote = noteDao.getPrevNote(id);
		Note nextNote = noteDao.getNextNote(id);
		note.setPrevNote(prevNote);
		note.setNextNote(nextNote);
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
		return 0;
	}

	public int addCommentOfNote(NoteComment comment, Integer noteId) {
		
		Note note = noteDao.get(noteId);
		note.getComments().add(comment);
		return 0;
	}

	/*public List<NoteComment> getNoteCommentList(Integer page) {
		
		List<NoteComment> list = noteCommentDao.getList(page);
		
		return list;
	}*/
	
}
