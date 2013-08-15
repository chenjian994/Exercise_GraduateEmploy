package com.cdvtc.graduateemploy.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.dao.IGraduateDAO;
import com.cdvtc.graduateemploy.model.Graduate;

@Component("graduateDAO")
public class GraduateDAOImpl implements IGraduateDAO {
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	private SessionFactory sf;
	public boolean delete(Graduate graduate) {
		Session s = sf.getCurrentSession();
		s.delete(graduate);
		return true;
	}
	public boolean deleteById(int id) {
		return false;
	}
	public Graduate findById(int id) {
		Session s = sf.getCurrentSession();
		String hql = "from Graduate g where g.id=?";
		return (Graduate)s.createQuery(hql).setInteger(0, id).uniqueResult();
	}
	public Graduate login(Graduate graduate) {
		Session s = sf.getCurrentSession();
		String hql = "from Graduate grad where grad.username=? and grad.password=?";
		List list = s.createQuery(hql).setString(0, graduate.getUsername()).setString(1, graduate.getPassword()).list();
		if(list.size() > 0) 
			return (Graduate) list.get(0);
		return null;
	}
	public boolean register(Graduate graduate) {
		Session s = sf.getCurrentSession();
		s.save(graduate);
		return true;
	}
	public boolean update(Graduate graduate) {
		Session s = sf.getCurrentSession();
		s.update(graduate);
		return true;
	}
	@SuppressWarnings("unchecked")
	public List<Graduate> findByVerify(Boolean verify) {
		Session s = sf.getCurrentSession();
		String hql = "from Graduate g where g.verified=?";
		return (List<Graduate>)s.createQuery(hql).setBoolean(0, verify).list();
	}
}
