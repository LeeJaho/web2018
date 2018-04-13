package com.notepubs.web.service.author;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.entity.Note;

@Service("authorNoteService")
public class NoteService {
	
	@Autowired
	private NoteDao noteDao;
	public List<Note> getNoteList(Integer page) {
		
		
		List<Note> list = noteDao.getList(page);
		return list;
	}

}
