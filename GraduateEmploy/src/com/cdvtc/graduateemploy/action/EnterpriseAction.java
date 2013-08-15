package com.cdvtc.graduateemploy.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.model.Enterprise;
import com.cdvtc.graduateemploy.model.Job;
import com.cdvtc.graduateemploy.service.IEnterpriseService;
import com.cdvtc.graduateemploy.service.IJobService;

@Component("enterpriseAction")
@Scope("prototype")
public class EnterpriseAction {
	@Resource(name="jobService")
	public void setJobService(IJobService jobService) {
		this.jobService = jobService;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public boolean isPerfect() {
		return isPerfect;
	}
	public void setPerfect(boolean isPerfect) {
		this.isPerfect = isPerfect;
	}
	@Resource(name="enterpriseService")
	public void setEs(IEnterpriseService es) {
		this.es = es;
	}
	public String infoManage() {
		if(null == ServletActionContext.getRequest().getSession().getAttribute("userId") || "".equals(ServletActionContext.getRequest().getSession().getAttribute("userId")))
			return "logout";		
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		isPerfect = es.isPerfectInfo(id);
		enterprise = es.findById(id);
		System.out.println(enterprise.getEmployeeAmount());
		return "infoManage";
	}
	public String updateInfo() {
		es.update(enterprise);
		return infoManage();
	}
	public String deleteInfo() {
		if(null == ServletActionContext.getRequest().getSession().getAttribute("userId") || "".equals(ServletActionContext.getRequest().getSession().getAttribute("userId")))
			return "logout";		
		enterprise.setId(Integer.parseInt(ServletActionContext.getRequest().getParameter("id")));
		es.deleteById(enterprise.getId());
		return "logout";
	}
	public String jobManage() {
		if(null == ServletActionContext.getRequest().getSession().getAttribute("userId") || "".equals(ServletActionContext.getRequest().getSession().getAttribute("userId")))
			return "logout";
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		jobs = new ArrayList<Job>(es.findById(id).getJobs());
		System.out.println(jobs.size() + "__________");
		return "jobManage";
	}
	public String newJob() {
		if(null == ServletActionContext.getRequest().getSession().getAttribute("userId") || "".equals(ServletActionContext.getRequest().getSession().getAttribute("userId")))
			return "logout";
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		enterprise = es.findById(id);
		job.setPublishDate(new Date());
		enterprise.setJobs(enterprise.getJobs() == null ? new HashSet<Job>():enterprise.getJobs());
		enterprise.getJobs().add(job);
		job.setEnterprise(enterprise);
		jobService.insert(job);
		return jobManage();
	}
	public String jobInfo() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		job = jobService.findById(id);
		return "jobInfo";
	}
	private IEnterpriseService es;
	private boolean isPerfect;
	private Enterprise enterprise = new Enterprise();
	private IJobService jobService;
	private List<Job> jobs;
	private Job job = new Job();
}
