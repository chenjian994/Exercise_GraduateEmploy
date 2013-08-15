package com.cdvtc.graduateemploy.dao;

import java.util.List;

import com.cdvtc.graduateemploy.model.Enterprise;

public interface IEnterpriseDAO {
	boolean register(Enterprise enterprise);
	Enterprise login(Enterprise enterprise);
	boolean update(Enterprise enterprise);
	Enterprise findById(int id);
	boolean delete(Enterprise enterprise);
	boolean deleteById(int id);
	List<Enterprise> findByVerify(Boolean verify);
}
