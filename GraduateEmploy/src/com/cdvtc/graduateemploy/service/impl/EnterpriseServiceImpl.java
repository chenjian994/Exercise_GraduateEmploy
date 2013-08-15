package com.cdvtc.graduateemploy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cdvtc.graduateemploy.dao.IEnterpriseDAO;
import com.cdvtc.graduateemploy.model.Enterprise;
import com.cdvtc.graduateemploy.service.IEnterpriseService;

@Transactional
@Component("enterpriseService")
public class EnterpriseServiceImpl implements IEnterpriseService {
	@Resource(name="enterpriseDAO")
	public void setEnterpriseDAO(IEnterpriseDAO enterpriseDAO) {
		this.enterpriseDAO = enterpriseDAO;
	}

	private IEnterpriseDAO enterpriseDAO;
	public boolean delete(Enterprise enterprise) {
		return enterpriseDAO.delete(enterprise);
	}
	public boolean deleteById(int id) {
		return enterpriseDAO.deleteById(id);
	}
	public Enterprise findById(int id) {
		return enterpriseDAO.findById(id);
	}
	public Enterprise login(Enterprise e) {
		return enterpriseDAO.login(e);
	}
	public boolean register(Enterprise e) {
		return enterpriseDAO.register(e);
	}
	public boolean update(Enterprise e) {
		return enterpriseDAO.update(e);
	}
	public List<Enterprise> findByVerify(Boolean verify) {
		return enterpriseDAO.findByVerify(verify);
	}
	public boolean isPerfectInfo(int id) {
		Enterprise e = findById(id);
		if(null == e) return false;
		else {
			if(null == e || "".equals(e.getAddress()) || null == e.getContact() ||
					"".equals(e.getContact()) || null == e.getEstablishDate() || 
					null == e.getWebsite() || "".equals(e.getWebsite()))
				return false;
		}
		return true;
	}

}
