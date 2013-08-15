package com.cdvtc.graduateemploy.dto;

import com.cdvtc.graduateemploy.model.Job;

public class JobInfo {
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public boolean isApplied() {
		return applied;
	}
	public void setApplied(boolean applied) {
		this.applied = applied;
	}
	private Job job;
	private boolean applied;
}
