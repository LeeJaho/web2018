package com.notepubs.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notepubs.web.dao.MemberDao;
import com.notepubs.web.dao.MemberRoleDao;
import com.notepubs.web.entity.Member;

@Service //보따리에 담겨지는 역할
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	@Transactional
	public int insertMember(Member member) {
		
		int result = memberDao.insert(member);
		
		//insert할 때 MemberRole 저자로 기본 설정해줘야 권한을 줄 수 있다
		//memberRole.insert(new MemberRole(, "ROLE_AUTHOR"));
		return result;
	}

	@Transactional
	public String getDefaultRoleByMemberId(String memberId) {
		String roleName = memberRoleDao.getDefaultRoleMemberId(memberId);
		
		return roleName;
	}

}
