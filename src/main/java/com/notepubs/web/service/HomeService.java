package com.notepubs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.dao.NoteLikeDao;
import com.notepubs.web.entity.NoteView;

@Service("homeService")
public class HomeService {
	
	@Autowired
	private NoteDao noteDao;
	
	@Autowired
	private NoteLikeDao noteLikeDao;
	
	public List<NoteView> getNoteList(Integer page) {
		
		//noteDao = new ?();
		List<NoteView> list = noteDao.getList(page);
		return list;
	}
}
