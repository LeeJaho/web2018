package com.notepubs.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.MemberDao;
import com.notepubs.web.entity.Member;

@Service //보따리에 담겨지는 역할
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	
	@Transactional
	public int insertMember(Member member) {
		
		int result = memberDao.insert(member);
		return result;
	}

}
