package com.notepubs.web.controller.author;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notepubs.web.entity.NoteView;
import com.notepubs.web.service.author.NoteService;




@RequestMapping("/author/note/")
@Controller("authorNoteController")
public class NoteController {
	
	@Autowired
	private NoteService service;
	
	@RequestMapping("list")
	public String list(Integer page, Model model) {
		
		List<NoteView> notes = service.getNoteList(page);
		
		
		model.addAttribute("notes", notes);
		
		return "author.note.list";
	}

}
