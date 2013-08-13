package com.cdvtc.graduateemploy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdvtc.graduateemploy.dao.IEnterpriseDAO;
import com.cdvtc.graduateemploy.model.Enterprise;
import com.cdvtc.graduateemploy.service.IEnterpriseService;

@Component("enterpriseService")
public class EnterpriseServiceImpl implements IEnterpriseService {
	@Resource(name="enterpriseDAO")
	public void setEnterpriseDAO(IEnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	private IEnterpriseDAO enterpriseDAO;
	@Transactional
	public boolean delete(Enterprise enterprise) {
		return enterpriseDAO.delete(enterprise);
	}
	@Transactional
	public boolean deleteById(int id) {
		return enterpriseDAO.deleteById(id);
	}
	@Transactional
	public Enterprise findById(int id) {
		return enterpriseDAO.findById(id);
	}
	@Transactional
	public boolean login(Enterprise e) {
		return enterpriseDAO.login(e);
	}
	@Transactional
	public boolean register(Enterprise e) {
		return enterpriseDAO.register(e);
	}
	@Transactional
	public boolean update(Enterprise e) {
		return enterpriseDAO.update(e);
	}

}
