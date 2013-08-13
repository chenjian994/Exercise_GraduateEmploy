package com.cdvtc.graduateemploy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.dao.IAdminDAO;
import com.cdvtc.graduateemploy.model.Admin;

@Component("adminDAO")
public class AdminDAOImpl implements IAdminDAO {
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	private SessionFactory sf;

	public boolean login(Admin admin) {
		Session s = sf.getCurrentSession();
		String hql = "from Admin ad where ad.username=? and password=?";
		int count = s.createQuery(hql)
					.setString(0, admin.getUsername())
					.setString(1, admin.getPassword())
					.list().size();
		if(count > 0) 
			return true;
		return false;
	}

	public boolean update(Admin admin) {
		Session s = sf.getCurrentSession();
		s.update(admin);
		return true;
	}

}
