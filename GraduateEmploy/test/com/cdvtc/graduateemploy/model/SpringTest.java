package com.cdvtc.graduateemploy.model;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.cdvtc.graduateemploy.service.IAdminService;

@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest extends AbstractJUnit4SpringContextTests {
	@Resource(name="adminService")
	IAdminService adminService;
	@Test
	public void adminTest() {
		Admin ad = new Admin();
		ad.setUsername("hello");
		ad.setPassword("world");
		adminService.login(ad);
	}
}
