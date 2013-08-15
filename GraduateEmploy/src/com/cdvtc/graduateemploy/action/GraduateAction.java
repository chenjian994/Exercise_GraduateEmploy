package com.cdvtc.graduateemploy.action;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.dto.JobInfo;
import com.cdvtc.graduateemploy.model.Graduate;
import com.cdvtc.graduateemploy.model.Job;
import com.cdvtc.graduateemploy.model.Profile;
import com.cdvtc.graduateemploy.service.IGraduateService;
import com.cdvtc.graduateemploy.service.IJobService;
import com.cdvtc.graduateemploy.service.IProfileService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("graduateAction")
public class GraduateAction extends ActionSupport {
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public List<JobInfo> getJobsInfo() {
		return jobsInfo;
	}
	public void setJobsInfo(List<JobInfo> jobsInfo) {
		this.jobsInfo = jobsInfo;
	}
	@Resource(name="jobService")
	public void setJs(IJobService js) {
		this.js = js;
	}
	@Resource(name="profileService")
	public void setPs(IProfileService ps) {
		this.ps = ps;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public Graduate getGraduate() {
		return graduate;
	}
	public void setGraduate(Graduate graduate) {
		this.graduate = graduate;
	}
	@Resource(name="graduateService")
	public void setGs(IGraduateService gs) {
		this.gs = gs;
	}
	public boolean isPerfect() {
		return perfect;
	}
	public void setPerfect(boolean perfect) {
		this.perfect = perfect;
	}
	public String profileManage() {
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		perfect = gs.isPerfectInfo(id);
		graduate = gs.findById(id);
		System.out.println(graduate.getUsername() + "*******************");
		return "profileManage";
	}
	public String updateProfile() {
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		Graduate g = gs.findById(id);
		graduate.setUsername(g.getUsername());
		graduate.setPassword(g.getPassword());
		graduate.setVerified(g.isVerified());
		graduate.setNo(id);
		System.out.println(graduate.getUsername() + "********************");
		gs.update(graduate);
		return profileManage();
	}
	public String addProfile() {
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		graduate = gs.findById(id);
		Profile p = new Profile();
		if(null != profileName || !"".equals(profileName)) {
			p.setExplain(profileName);
			p.setType("获奖证书");
			graduate.setProfiles(graduate.getProfiles() == null ? new HashSet<Profile>():graduate.getProfiles());
			p.setGraduate(graduate);
			ps.insert(p);
		}
		return updateProfile();
	}
	public String showProfile() {
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		graduate = gs.findById(id);
		return "showProfile";
	}
	public String jobList() {
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		jobsInfo = new ArrayList<JobInfo>();
		List<Job> jobs = js.list();
		Iterator<Job> jIter = jobs.iterator();
		JobInfo ji = null;
		Iterator<Graduate> gIter = null;
		while(jIter.hasNext()) {
			job = jIter.next();
			ji = new JobInfo();
			ji.setJob(job);
			gIter = job.getGraduates().iterator();
			while(gIter.hasNext()) {
				if(id == gIter.next().getNo()) {
					ji.setApplied(true);
					break;
				}
			}
			jobsInfo.add(ji);
		}
		return "jobList";
	}
	public String applyJob() {
		int jid = Integer.parseInt(ServletActionContext.getRequest().getParameter("jid"));
		int id = (Integer) ServletActionContext.getRequest().getSession().getAttribute("userId");
		job = js.findById(jid);
		graduate = gs.findById(id);
		job.setGraduates(job.getGraduates() == null ? new HashSet<Graduate>():job.getGraduates());
		graduate.setJobs(graduate.getJobs() == null ? new HashSet<Job>():graduate.getJobs());
		graduate.getJobs().add(job);
		job.getGraduates().add(graduate);
		gs.update(graduate);
		js.update(job);
		return jobList();
	}
	public String jobInfo() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		job = js.findById(id);
		return "jobInfo";
	}
	private Job job = null;
	private List<JobInfo> jobsInfo;
	private String profileName;
	private boolean perfect;
	private Graduate graduate;
	private IJobService js;
	private IGraduateService gs;
	private IProfileService ps;
}
