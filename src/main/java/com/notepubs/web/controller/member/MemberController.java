package com.notepubs.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notepubs.web.entity.Member;
import com.notepubs.web.entity.Note;
import com.notepubs.web.service.MemberService;

//Controller @Controller -> Service @Service -> Dao : HbDao @Repository
@RequestMapping("/member/")
@Controller("memberController")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("join")
	public String join() {
		
		return "member.join";
	}
	
	@PostMapping("join")
	@ResponseBody
	public String join(Member member) {
		
		String pwd = member.getPwd();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPwd = passwordEncoder.encode(pwd);
		member.setPwd(hashedPwd);
		
		int result = service.insertMember(member);
		return pwd + " : " + hashedPwd;
	}
	
	@GetMapping("login")
	public String login() {
		
		return "member.login";
	}
	
}
