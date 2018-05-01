package com.notepubs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.dao.NoteLikeDao;
import com.notepubs.web.entity.NoteLike;
import com.notepubs.web.entity.NoteView;



@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;
	
	public List<NoteView> getNoteList(Integer page) {
		
		//noteDao = new ?();
		List<NoteView> list = noteDao.getList(page);
		return list;
	}

	public NoteView getNote(Integer id) {
		
		NoteView note = noteDao.get(id);
		NoteView prevNote = noteDao.getPrevNote(id);
		NoteView nextNote = noteDao.getNextNote(id);
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
	
}
