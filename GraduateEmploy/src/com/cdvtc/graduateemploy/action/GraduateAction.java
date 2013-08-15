package com.cdvtc.graduateemploy.action;

import java.util.HashSet;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.model.Graduate;
import com.cdvtc.graduateemploy.model.Profile;
import com.cdvtc.graduateemploy.service.IGraduateService;
import com.cdvtc.graduateemploy.service.IProfileService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("graduateAction")
public class GraduateAction extends ActionSupport {
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
		return "profileManage";
	}
	public String updateProfile() {
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		graduate.setNo(id);
		gs.update(graduate);
		return profileManage();
	}
	public String addProfile() {
		int id = (Integer)ServletActionContext.getRequest().getSession().getAttribute("userId");
		graduate = gs.findById(id);
		Profile p = new Profile();
		p.setExplain(profileName);
		p.setType("获奖证书");
		graduate.setProfiles(graduate.getProfiles() == null ? new HashSet<Profile>():graduate.getProfiles());
		p.setGraduate(graduate);
		ps.insert(p);
		return updateProfile();
	}
	private String profileName;
	private boolean perfect;
	private Graduate graduate;
	private IGraduateService gs;
	private IProfileService ps;
}
