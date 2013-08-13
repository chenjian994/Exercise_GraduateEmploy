package com.cdvtc.graduateemploy.dao;

import com.cdvtc.graduateemploy.model.Admin;

public interface IAdminDAO {
	boolean login(Admin admin);
	boolean update(Admin admin);
}
