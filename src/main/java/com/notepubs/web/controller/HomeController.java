package com.notepubs.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.notepubs.web.service.HomeService;

@Controller("rootController")
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private HomeService service;
	
	
	@GetMapping("index")
	public String index(
			@CookieValue(value="vid", /*쿠키 안들어왔을 때*/ defaultValue="") String vid
			, HttpServletResponse response
			, Model model) {
		//기본적으로 파라미터로 인식하기 때문에 2, 3 이용 시 anotation으로 언급 해줘야함
		//1. parameter , 2. @PathValue // 3.cookie -> @CookieValue
		//절대 겹칠 수 없는 아이디를 만들어줌 UUID
		
		//방문한 적이 없었다면 쿠키 추가시켜줘라
		if(vid == null || vid.equals("")) {
			vid = UUID.randomUUID().toString();
			Cookie cookie = new Cookie("vid", vid);
			cookie.setMaxAge(60*60*24*365);
			//cookie를 가져올 수 있는 위치
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		
		//방문한 적 있다면 bool 값 넘겨주자 view단으로
		else
			model.addAttribute("visited", "true");
		
		return "index";
	}
	
	@GetMapping("book-list-partial")
	public String bookListPartial() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "book-list-partial";
	}
	
	@GetMapping("note-photo-list")
	@ResponseBody
	public String notePhotoList(HttpServletRequest request) {
		
		String url = "/resources/js/images";
		String path = request.getServletContext().getRealPath(url);
		List<String> fileNames = new ArrayList<>();
		
		File file = new File(path);
		
		//StringBuilder builder = new StringBuilder();
		
		
		File[] files = file.listFiles();
		/*for(int i = 0; i < file.list().length; i++)
			System.out.println(files[i].getName());*/
		for(File f : files)
			fileNames.add(f.getName());
		
		/*builder.append("[");
		
		for(int i = 0; i < fileNames.size(); i++) {
			builder.append(fileNames.get(i));
			
			if(i < fileNames.size()-1)
				builder.append(",");
		}
		builder.append("]");*/
		
		//Json-simple 이용?
		/*JSONObject jsonObject = new JSONObject();
		JSONObject photoList = new JSONObject();
		 
		for(int i = 0; i < fileNames.size(); i++)
			photoList.put("photo"+(i+1), fileNames.get(i));
		
		jsonObject.put("photo", photoList);*/
		
		
		
		//gson 라이브러리
		return new Gson().toJson(fileNames);//jsonObject.toString(); //builder.toString();
	}
}
