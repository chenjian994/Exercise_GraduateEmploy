package com.cdvtc.graduateemploy.dao;

import com.cdvtc.graduateemploy.model.Enterprise;

public interface IEnterpriseDAO {
	boolean register(Enterprise enterprise);
	boolean login(Enterprise enterprise);
	boolean update(Enterprise enterprise);
	Enterprise findById(int id);
	boolean delete(Enterprise enterprise);
	boolean deleteById(int id);
}
