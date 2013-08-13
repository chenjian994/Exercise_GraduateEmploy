package com.cdvtc.graduateemploy.model;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class ModelTest {
	public static void main(String[] args) {
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
}
