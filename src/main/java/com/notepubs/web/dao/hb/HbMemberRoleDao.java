package com.notepubs.web.dao.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.MemberRoleDao;
import com.notepubs.web.entity.MemberRole;


@Repository
public class HbMemberRoleDao implements MemberRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String getDefaultRoleMemberId(String memberId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		//
		List<MemberRole> list = session.createQuery(/*HQL*/"from MemberRole mr where mr.defaultRole=1").getResultList();
		
		String roleName = list.get(0).getRoleId();
		
		
		
		return roleName;
	}

}
