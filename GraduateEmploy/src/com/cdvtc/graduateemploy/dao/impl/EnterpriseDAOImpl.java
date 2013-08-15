package com.cdvtc.graduateemploy.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
		return deleteById(enterprise.getId());
	}

	public boolean deleteById(int id) {
		Session s = sf.getCurrentSession();
		String hql = "delete from Enterprise e where e.id=?";
		int rows = s.createQuery(hql).setInteger(0, id).executeUpdate();
		if(rows > 0) return true;
		return false;
	}

	public Enterprise findById(int id) {
		Session s = sf.getCurrentSession();
		String hql = "from Enterprise e where e.id=?";
		Enterprise e = (Enterprise)s.createQuery(hql).setInteger(0, id).uniqueResult();
		if(null != e.getEstablishDate()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				System.out.println(e + "___" + sdf + "___");
				e.setEstablishDate(sdf.parse(sdf.format(e.getEstablishDate())));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		
		return e;
	}

	public Enterprise login(Enterprise enterprise) {
		Session s = sf.getCurrentSession();
		String hql = "from Enterprise enter where enter.username=? and enter.password=?";
		List list = s.createQuery(hql).setString(0, enterprise.getUsername()).setString(1, enterprise.getPassword()).list();
		if(list.size() > 0)
			return (Enterprise) list.get(0);
		return null;
	}

	public boolean register(Enterprise enterprise) {
		Session s = sf.getCurrentSession();
		s.save(enterprise);
		return true;
	}

	public boolean update(Enterprise enterprise) {
		Session s = sf.getCurrentSession();
		if(null != enterprise.getEstablishDate()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				enterprise.setEstablishDate(sdf.parse(sdf.format(enterprise.getEstablishDate())));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		s.update(enterprise);
		return true;
	}
	private SessionFactory sf;
	@SuppressWarnings("unchecked")
	public List<Enterprise> findByVerify(Boolean verify) {
		Session s = sf.getCurrentSession();
		String hql = "from Enterprise e where e.verified=?";
		return s.createQuery(hql).setBoolean(0, verify).list();
	}
}
