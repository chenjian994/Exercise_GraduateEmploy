package com.cdvtc.graduateemploy.service;

import com.cdvtc.graduateemploy.model.Admin;

public interface IAdminService {
	boolean login(Admin admin);
	boolean update(Admin admin);
}
