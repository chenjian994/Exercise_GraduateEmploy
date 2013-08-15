package com.cdvtc.graduateemploy.service;

import java.util.List;

import com.cdvtc.graduateemploy.model.Job;

public interface IJobService {
	boolean delete(Job job);
	boolean deleteById(int id);
	Job findById(int id);
	boolean insert(Job job);
	boolean update(Job job);
	List<Job> list();
}
