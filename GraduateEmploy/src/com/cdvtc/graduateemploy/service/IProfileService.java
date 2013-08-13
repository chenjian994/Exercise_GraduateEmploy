package com.cdvtc.graduateemploy.service;

import com.cdvtc.graduateemploy.model.Profile;

public interface IProfileService {
	boolean delete(Profile p);
	boolean deleteById(int id);
	Profile findById(int id);
	boolean insert(Profile p);
	boolean update(Profile p);
}
