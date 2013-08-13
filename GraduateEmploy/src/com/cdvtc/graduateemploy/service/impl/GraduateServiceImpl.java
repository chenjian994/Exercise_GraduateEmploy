package com.cdvtc.graduateemploy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdvtc.graduateemploy.dao.IGraduateDAO;
import com.cdvtc.graduateemploy.model.Graduate;
import com.cdvtc.graduateemploy.service.IGraduateService;

@Component("graduateService")
public class GraduateServiceImpl implements IGraduateService {
	@Resource(name="graduateDAO")
	public void setGraduateDAO(IGraduateDAO graduateDAO) {
		this.graduateDAO = graduateDAO;
	}
	@Transactional
	public boolean delete(Graduate e) {
		return graduateDAO.delete(e);
	}
	@Transactional
	public boolean login(Graduate e) {
		return graduateDAO.login(e);
	}
	@Transactional
	public boolean register(Graduate e) {
		return graduateDAO.register(e);
	}
	@Transactional
	public boolean update(Graduate e) {
		return graduateDAO.update(e);
	}
	@Transactional
	public boolean deleteById(int id) {
		return graduateDAO.deleteById(id);
	}
	@Transactional
	public Graduate findById(int id) {
		return graduateDAO.findById(id);
	}
	
	private IGraduateDAO graduateDAO;

}

