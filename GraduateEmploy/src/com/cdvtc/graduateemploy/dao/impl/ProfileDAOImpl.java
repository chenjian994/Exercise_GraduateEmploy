package com.cdvtc.graduateemploy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.dao.IProfileDAO;
import com.cdvtc.graduateemploy.model.Profile;

@Component("profileDAO")
public class ProfileDAOImpl implements IProfileDAO {
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	private SessionFactory sf;
	public boolean delete(Profile profile) {
		return deleteById(profile.getId());
	}

	public boolean deleteById(int id) {
		Session s = sf.getCurrentSession();
		String hql = "delete from Profile p where p.id=?";
		int size = s.createQuery(hql).setInteger(0, id).executeUpdate();
		if(size > 0) return true;
		return false;
	}

	public Profile findById(int id) {
		Session s = sf.getCurrentSession();
		String hql = "from Profile p where p.id=?";
		Profile p = (Profile)s.createQuery(hql).setInteger(0, id).uniqueResult();
		return p;
	}

	public boolean insert(Profile profile) {
		Session s = sf.getCurrentSession();
		s.save(profile);
		return true;
	}

	public boolean update(Profile profile) {
		Session s = sf.getCurrentSession();
		s.update(profile);
		return true;
	}

}
