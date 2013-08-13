package com.cdvtc.graduateemploy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.dao.IEnterpriseDAO;
import com.cdvtc.graduateemploy.model.Enterprise;

@Component("enterpriseDAO")
public class EnterpriseDAOImpl implements IEnterpriseDAO {
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public boolean delete(Enterprise enterprise) {
		Session s = sf.getCurrentSession();
		s.delete(enterprise);
		return true;
	}

	public boolean deleteById(int id) {
		return false;
	}

	public Enterprise findById(int id) {
		return null;
	}

	public boolean login(Enterprise enterprise) {
		Session s = sf.getCurrentSession();
		String hql = "from Enterprise enter where enter.username=? and enter.password=?";
		int size = s.createQuery(hql).setString(0, enterprise.getUsername()).setString(1, enterprise.getPassword()).list().size();
		if(size > 0) return true;
		return false;
	}

	public boolean register(Enterprise enterprise) {
		Session s = sf.getCurrentSession();
		s.save(enterprise);
		return true;
	}

	public boolean update(Enterprise enterprise) {
		Session s = sf.getCurrentSession();
		s.update(enterprise);
		return true;
	}
	private SessionFactory sf;
}
