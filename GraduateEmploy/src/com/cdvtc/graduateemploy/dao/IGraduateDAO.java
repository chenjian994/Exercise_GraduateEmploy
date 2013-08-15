package com.cdvtc.graduateemploy.dao;

import java.util.List;

import com.cdvtc.graduateemploy.model.Graduate;

public interface IGraduateDAO {
	boolean register(Graduate graduate);
	Graduate login(Graduate graduate);
	boolean update(Graduate graduate);
	boolean delete(Graduate graduate);
	boolean deleteById(int id);
	Graduate findById(int id);
	List<Graduate> findByVerify(Boolean verify);
}
