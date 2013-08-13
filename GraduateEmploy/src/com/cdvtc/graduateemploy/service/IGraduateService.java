package com.cdvtc.graduateemploy.service;

import com.cdvtc.graduateemploy.model.Graduate;

public interface IGraduateService {
	boolean delete(Graduate e);
	boolean deleteById(int id);
	Graduate findById(int id);
	boolean login(Graduate e);
	boolean register(Graduate e);
	boolean update(Graduate e);
}
