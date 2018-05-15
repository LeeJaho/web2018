package com.notepubs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.NoteDao;
import com.notepubs.web.dao.NoteLikeDao;
import com.notepubs.web.entity.Note;
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
		
		//list의 각 Note 객체마다 관련 NoteComment 객체를
		//1 : N으로 담는다
		
		
		return list;
	}
}
