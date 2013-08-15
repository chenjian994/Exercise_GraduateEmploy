package com.cdvtc.graduateemploy.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.dao.IJobDAO;
import com.cdvtc.graduateemploy.model.Job;

@Component("jobDAO")
public class JobDAOImpl implements IJobDAO {
	@Resource(name="sessionFactory")
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	private SessionFactory sf;
	public boolean delete(Job job) {
		return deleteById(job.getId());
	}

	public boolean deleteById(int id) {
		Session s = sf.getCurrentSession();
		String hql = "delete from Job j where j.id=?";
		int size = s.createQuery(hql).setInteger(0, id).executeUpdate();
		if(size > 0) return true;
		return false;
	}

	public Job findById(int id) {
		Session s = sf.getCurrentSession();
		String hql = "from Job j where j.id=?";
		Job job = (Job)s.createQuery(hql).setInteger(0, id).uniqueResult();
		return job;
	}

	public boolean insert(Job job) {
		Session s = sf.getCurrentSession();
		s.save(job);
		return true;
	}

	public boolean update(Job job) {
		Session s = sf.getCurrentSession();
		s.update(job);
		return true;
	}

}
