package com.notepubs.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.notepubs.web.entity.Note;
import com.notepubs.web.entity.NoteComment;

import com.notepubs.web.service.NoteService;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;



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
	
	@RequestMapping("ajax-list")
	@ResponseBody
	public String list(@RequestParam(value="p", defaultValue="1") Integer page) {
		
		//List<NoteComment> comments = service.getNoteCommentList(page);
		List<Note> notes = service.getNoteList(page);
		
		return new Gson().toJson(notes);
	}
	
	/*
	 * http: ~~~~~~ /note/detail?id=3 -> param으로 id를 읽는다
	 * http: ~~~~~~ /note/3 -> param으로 id를 못읽는다 -> 경로기 때문에
	 */
	@GetMapping("{id}") //일일이 다 1 2 3 4 설정할 수 없으니까 -> 
	//파라미터로 id가 올 수 있는데 -> param으로 못읽는 id를 pathVariable을 통해 경로 전달
	//그것을 잡는게 아니라 경로로 잡는다!
	//pathVariable -> 경로에 대한 정보?!
	public String detail(@PathVariable("id") Integer id, Model model) {
		
		//NoteView prev = service.getPrevNote(id);
		//NoteView next = service.getNextNote(id);
		Note note = service.getNote(id);
		model.addAttribute("note", note);
		//model.addAllAttributes("prev",prev);
		return "note.detail";
	}
	
	@GetMapping("{id}/like") //일일이 다 1 2 3 4 설정할 수 없으니까 -> 
	//파라미터로 id가 올 수 있는데 -> param으로 못읽는 id를 pathVariable을 통해 경로 전달
	//그것을 잡는게 아니라 경로로 잡는다!
	//pathVariable -> 경로에 대한 정보?!
	public String like(@PathVariable("id") Integer noteId
			, Model model
			, Principal principal) {
		//인증정보
		String memberId = "jahojaho";//principal.getName();
		
		service.setNoteLike(noteId, memberId);
		
		return "redirect:../" + noteId;
	}
	
	@PostMapping("{id}/comment/reg")
	@ResponseBody
	public String commentReg(NoteComment comment
			, @RequestParam("nic-name") String nicName
			, @RequestParam(value="secret", defaultValue="false") Boolean secret
			, @PathVariable("id") Integer noteId) {
		
		//결과값 던져줌
		comment.setSecret(secret);
		comment.setNicName(nicName);
		
		//comment.setNoteId(noteId); //이게 무의미함 -> NoteComment에서 어차피 noteId는 insertable=false니까
		int result = service.addCommentOfNote(comment, noteId);
		
		return String.valueOf(result); //"redirect:../../detail" 백엔드상에서 재갱신 느낌
								//ajax로 하려면 등록되었다 상태만 알려주고 프론트에서 해줌
	}
	
	
}
