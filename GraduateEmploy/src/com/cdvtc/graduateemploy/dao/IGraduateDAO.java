package com.cdvtc.graduateemploy.dao;

import com.cdvtc.graduateemploy.model.Graduate;

public interface IGraduateDAO {
	boolean register(Graduate graduate);
	boolean login(Graduate graduate);
	boolean update(Graduate graduate);
	boolean delete(Graduate graduate);
	boolean deleteById(int id);
	Graduate findById(int id);
}
