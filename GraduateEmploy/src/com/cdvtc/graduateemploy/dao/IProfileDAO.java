package com.cdvtc.graduateemploy.dao;

import com.cdvtc.graduateemploy.model.Profile;

public interface IProfileDAO {
	boolean insert(Profile profile);
	boolean update(Profile profile);
	boolean delete(Profile profile);
	boolean deleteById(int id);
	Profile findById(int id);
}
