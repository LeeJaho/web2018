package com.notepubs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.dao.NoteLikeDao;

import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteLike;



@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;
	
	public List<Note> getNoteList(Integer page) {
		
		//noteDao = new ?();
		List<Note> list = noteDao.getList(page);
		return list;
	}

	public Note getNote(Integer id) {
		
		Note note = noteDao.get(id);
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
