package com.cdvtc.graduateemploy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdvtc.graduateemploy.dao.IAdminDAO;
import com.cdvtc.graduateemploy.model.Admin;
import com.cdvtc.graduateemploy.service.IAdminService;

@Transactional
@Component("adminService")
public class AdminServiceImpl implements IAdminService {
	public boolean login(Admin admin) {
		return adminDAO.login(admin);
	}

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
