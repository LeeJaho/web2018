package com.notepubs.web.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.notepubs.web.dao.MemberDao;
import com.notepubs.web.entity.Member;
import com.notepubs.web.entity.Note;

@Repository
public class HbMemberDao implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public int insert(Member member) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(member);
		return 1;
	}
}
