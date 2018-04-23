package com.notepubs.web.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.notepubs.web.service.MemberService;

@Component
public class NotepubsLoginSuccessHandler 
	implements AuthenticationSuccessHandler {
	
	@Autowired
	private MemberService service;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request
			, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		String memberId = authentication.getName();
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		
		System.out.println(memberId);
		for(String role : roles)
			System.out.println(role);
		
		HttpSession session = request.getSession();
		
		if(session != null) {
			SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			
			if(savedRequest != null) {// 요청에 인터럽트가 걸린 경우 -> 가려던 그 페이지로 보내줘야함
				String returnUrl = savedRequest.getRedirectUrl();
				System.out.println(returnUrl);
				redirectStrategy.sendRedirect(request, response, returnUrl);
				
			}
			
			else {//직접 로그인을 요청한 경우
				String defaultRole = service.getDefaultRoleByMemberId(memberId);
				
				//로그인 온 경우 해당 조건에 따라서 redirect 해준다
				switch(defaultRole) {
				case "ROLE_AUTHOR":
					redirectStrategy.sendRedirect(request, response, "/author/index");
					break;
				case "ROLE_ADMIN":
					redirectStrategy.sendRedirect(request, response, "/admin/index");
					break;
				default:
					//error페이지로 보내기
					break;
				}
				
			}
		}
		
	}
	
}
