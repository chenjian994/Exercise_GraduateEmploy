package com.cdvtc.graduateemploy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdvtc.graduateemploy.dao.IAdminDAO;
import com.cdvtc.graduateemploy.model.Admin;
import com.cdvtc.graduateemploy.service.IAdminService;

@Component("adminService")
public class AdminServiceImpl implements IAdminService {
	@Transactional
	public boolean login(Admin admin) {
		return adminDAO.login(admin);
	}

	@Transactional
	public boolean update(Admin admin) {
		return adminDAO.update(admin);
	}

	public IAdminDAO getAdminDAO() {
		return adminDAO;
	}
	@Resource(name="adminDAO")
	public void setAdminDAO(IAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	private IAdminDAO adminDAO;
}
