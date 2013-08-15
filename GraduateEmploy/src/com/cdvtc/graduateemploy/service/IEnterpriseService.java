package com.cdvtc.graduateemploy.service;

import java.util.List;

import com.cdvtc.graduateemploy.model.Enterprise;

public interface IEnterpriseService {
	boolean delete(Enterprise enterprise);
	boolean deleteById(int id);
	Enterprise findById(int id);
	Enterprise login(Enterprise e);
	boolean register(Enterprise e);
	boolean update(Enterprise e);
	boolean isPerfectInfo(int id);
	List<Enterprise> findByVerify(Boolean verify);
}
