package com.notepubs.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notepubs.web.entity.Note;
import com.notepubs.web.service.NoteService;



@RequestMapping("/note/")
@Controller("noteController")
public class NoteController {
	
	@Autowired
	private NoteService service;
	
	@RequestMapping("list")
	public String list(@RequestParam(value="p", defaultValue="1") Integer page, Model model) {
		
		List<Note> notes = service.getNoteList(page);
		model.addAttribute("notes", notes);
		//System.out.println(page);
		//String page = request.getParameter("p"); //더이상 이렇게 사용하지 않아도 됨
		
		return "note.list";
	}
	
	
	
	/*
	 * http: ~~~~~~ /note/detail?id=3 -> param으로 id를 읽는다
	 * http: ~~~~~~ /note/3 -> param으로 id를 못읽는다 -> 경로기 때문에
	 */
	@RequestMapping("{id}") //일일이 다 1 2 3 4 설정할 수 없으니까 -> 
	//파라미터로 id가 올 수 있는데 -> param으로 못읽는 id를 pathVariable을 통해 경로 전달
	//그것을 잡는게 아니라 경로로 잡는다!
	//pathVariable -> 경로에 대한 정보?!
	public String detail(@PathVariable("id") Integer id, Model model) {
		
		Note note = service.getNote(id);
		model.addAttribute("note", note);
		return "note.detail";
	}
}
