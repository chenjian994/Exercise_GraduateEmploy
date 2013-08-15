package com.cdvtc.graduateemploy.action;

import java.util.Enumeration;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cdvtc.graduateemploy.model.Admin;
import com.cdvtc.graduateemploy.model.Enterprise;
import com.cdvtc.graduateemploy.model.Graduate;
import com.cdvtc.graduateemploy.service.IAdminService;
import com.cdvtc.graduateemploy.service.IEnterpriseService;
import com.cdvtc.graduateemploy.service.IGraduateService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
	@Resource(name="adminService")
	public void setAs(IAdminService as) {
		this.as = as;
	}

	@Resource(name="graduateService")
	public void setGs(IGraduateService gs) {
		this.gs = gs;
	}

	@Resource(name="enterpriseService")
	public void setEs(IEnterpriseService es) {
		this.es = es;
	}

	@SuppressWarnings("deprecation")
	public String login() {
		if(null==getUsername() || "".equals(getUsername()) || null == getPassword() || "".equals(getPassword())) {
			addFieldError("loginErr", "用户名和密码不能为空");
			return "input";
		}
		System.out.println("username:" + getUsername() + "   password: " + getPassword() + "  identity：" + idenities[getIdentity()]);
		String err = "";
		if(0 == getIdentity()) {
			Admin admin = new Admin();
			admin.setUsername(getUsername());
			admin.setPassword(getPassword());
			boolean bool = as.login(admin);
			System.out.println("_______" + bool);
			if(bool){
				ServletActionContext.getRequest().getSession().putValue("userId", admin.getId());
				ServletActionContext.getRequest().getSession().putValue("username", admin.getUsername());
				return "admin";
			}
			else err="用户名或密码错误";
		} else if (1 == getIdentity()) {
			Enterprise enterprise = new Enterprise();
			enterprise.setUsername(getUsername());
			enterprise.setPassword(getPassword());
			enterprise = es.login(enterprise);
			if(null != enterprise) 
				if(!enterprise.isVerified())
					err="你的注册尚未通过验证";
				else {
					ServletActionContext.getRequest().getSession().putValue("userId", enterprise.getId());
					ServletActionContext.getRequest().getSession().putValue("username", enterprise.getUsername());					
					return "enterprise";
				}
			else 
				err="用户名或密码错误";
		} else if(2 == getIdentity()) {
			Graduate graduate = new Graduate();
			graduate.setUsername(getUsername());
			graduate.setPassword(getPassword());
			graduate = gs.login(graduate);
			if(null != graduate) {
				if(!graduate.isVerified()) 
					err="用户名或密码错误";
				else {
					ServletActionContext.getRequest().getSession().putValue("userId", graduate.getNo());
					ServletActionContext.getRequest().getSession().putValue("username", graduate.getUsername());
					return "graduate";
				}
			}
			else
				err="你的注册尚未通过验证";
		}
		addFieldError("loginErr", err);
		return "input";
	}
	
	public String register() {
		System.out.println("username:" + getUsername() + "  password:" + getPassword() + "   rePassword:" + getRePassword()
				+ "   identity:" + idenities[getIdentity()] + "   email:" + getEmail() + "   phone:" + getPhone());
		if(getPassword() != null && !getPassword().equals(getRePassword())) {
			addFieldError("registerErr", "两次输入的密码不一致");
			return INPUT;
		}
		if(1 == getIdentity()) {
			Enterprise enterprise = new Enterprise();
			enterprise.setUsername(getUsername());
			enterprise.setPassword(getPassword());
			enterprise.setEmail(getEmail());
			enterprise.setPhone(getPhone());
			es.register(enterprise);
		} else if(2 == getIdentity()) {
			Graduate graduate = new Graduate();
			graduate.setUsername(getUsername());
			graduate.setPassword(getPassword());
			graduate.setEmail(getEmail());
			graduate.setPhone(getPhone());
			gs.register(graduate);
		}
		return "registerSuc";
	}
	public String logout() {
		Enumeration<String> e = ServletActionContext.getRequest().getSession().getAttributeNames();
		while(e.hasMoreElements()) {
			ServletActionContext.getRequest().getSession().removeAttribute(e.nextElement());
		}
		return INPUT;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String username;
	private String password;
	private String rePassword;
	private int identity;
	private String email;
	private String phone;
	private IAdminService as;
	private IEnterpriseService es;
	private IGraduateService gs;
	public final static String[] idenities = {"admin", "company", "graduate"};
}
