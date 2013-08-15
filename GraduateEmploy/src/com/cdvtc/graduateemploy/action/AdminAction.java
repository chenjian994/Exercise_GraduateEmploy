package com.cdvtc.graduateemploy.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.dto.VerifyList;
import com.cdvtc.graduateemploy.model.Enterprise;
import com.cdvtc.graduateemploy.model.Graduate;
import com.cdvtc.graduateemploy.service.IEnterpriseService;
import com.cdvtc.graduateemploy.service.IGraduateService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport{
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	@Resource(name="graduateService")
	public void setGs(IGraduateService gs) {
		this.gs = gs;
	}
	@Resource(name="enterpriseService")
	public void setEs(IEnterpriseService es) {
		this.es = es;
	}
	public String regInfoVerify() {
		Iterator<Enterprise> enter = es.findByVerify(false).iterator();
		Enterprise _e;
		VerifyList vl = null;
		while(enter.hasNext()) {
			_e = enter.next();
			vl = new VerifyList();
			vl.setId(_e.getId());
			vl.setUsername(_e.getUsername());
			vl.setEmail(_e.getEmail());
			vl.setIdentity("company");
			vl.setPhone(_e.getPhone());
//			System.out.println("company");
			verifyList.add(vl);
		}
		Iterator<Graduate> grad = gs.findByVerify(false).iterator();
		Graduate _g;
		while(grad.hasNext()) {
			_g = grad.next();
			vl = new VerifyList();
			vl.setId(_g.getNo());
			vl.setUsername(_g.getUsername());
			vl.setEmail(_g.getEmail());
			vl.setIdentity("graduate");
			vl.setPhone(_g.getPhone());
//			System.out.println("graduate");
			verifyList.add(vl);
		}
		return "regInfoVerify";
	}
	public String activityUser() {
		if("company".equals(identity)) {
			Enterprise e = es.findById(id);
			e.setVerified(true);
			es.update(e);
		} else if("graduate".equals(identity)) {
			Graduate g = gs.findById(id);
			g.setVerified(true);
			gs.update(g);
		}
		return regInfoVerify();
	}
	public List<VerifyList> getVerifyList() {
		return verifyList;
	}
	public void setVerifyList(List<VerifyList> verifyList) {
		this.verifyList = verifyList;
	}
	private int id;
	private String identity;
	private List<VerifyList> verifyList = new ArrayList<VerifyList>();
	private IGraduateService gs;
	private IEnterpriseService es;
}
