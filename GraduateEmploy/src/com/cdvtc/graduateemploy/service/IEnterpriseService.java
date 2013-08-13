package com.cdvtc.graduateemploy.service;

import com.cdvtc.graduateemploy.model.Enterprise;

public interface IEnterpriseService {
	boolean delete(Enterprise enterprise);
	boolean deleteById(int id);
	Enterprise findById(int id);
	boolean login(Enterprise e);
	boolean register(Enterprise e);
	boolean update(Enterprise e);
}
