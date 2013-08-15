package com.cdvtc.graduateemploy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdvtc.graduateemploy.dao.IGraduateDAO;
import com.cdvtc.graduateemploy.model.Graduate;
import com.cdvtc.graduateemploy.service.IGraduateService;

@Transactional
@Component("graduateService")
public class GraduateServiceImpl implements IGraduateService {
	@Resource(name="graduateDAO")
	public void setGraduateDAO(IGraduateDAO graduateDAO) {
		this.graduateDAO = graduateDAO;
	}
	public boolean delete(Graduate e) {
		return graduateDAO.delete(e);
	}
	public Graduate login(Graduate e) {
		return graduateDAO.login(e);
	}
	public boolean register(Graduate e) {
		return graduateDAO.register(e);
	}
	public boolean update(Graduate e) {
		return graduateDAO.update(e);
	}
	public boolean deleteById(int id) {
		return graduateDAO.deleteById(id);
	}
	public Graduate findById(int id) {
		return graduateDAO.findById(id);
	}
	
	private IGraduateDAO graduateDAO;

	public List<Graduate> findByVerify(Boolean verify) {
		return graduateDAO.findByVerify(verify);
	}
	public boolean isPerfectInfo(int id) {
		Graduate g = findById(id);
		if(null == g) return false;
		else {
			if(null == g.getAddition() || "".equals(g.getAddition()) || null == g.getAddress() ||
					"".equals(g.getAddress()) || null == g.getBackground() || "".equals(g.getBackground()) ||
					null == g.getCollege() || "".equals(g.getCollege()) || null == g.getMajor() || "".equals(g.getMajor()) ||
					null == g.getSex() || "".equals(g.getSex()) || null == g.getSelfEval() || "".equals(g.getSelfEval())) {
				return false;
			}
		}
		return true;
	}

}

