package com.notepubs.web.controller.author;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notepubs.web.entity.Note;
import com.notepubs.web.service.author.NoteService;


@Controller("authorHomeController")
@RequestMapping("/author/")
public class HomeController {
	
	@GetMapping("index")
	public String index() {
		
		return "author.index";
	}

}
