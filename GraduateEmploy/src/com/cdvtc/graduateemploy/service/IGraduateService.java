package com.cdvtc.graduateemploy.service;

import java.util.List;

import com.cdvtc.graduateemploy.model.Graduate;

public interface IGraduateService {
	boolean delete(Graduate e);
	boolean deleteById(int id);
	Graduate findById(int id);
	Graduate login(Graduate e);
	boolean register(Graduate e);
	boolean update(Graduate e);
	boolean isPerfectInfo(int id);
	List<Graduate> findByVerify(Boolean verify);
}
