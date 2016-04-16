package com.qio.model.tenant.helper;

import com.qio.model.tenant.Tenant;


public class TenantHelper {
	Tenant tenant;
	
	// creates a tenant with default values for its properties.
	public TenantHelper(){
		java.util.Date date= new java.util.Date();
		String timestamp = Long.toString(date.getTime());
		tenant = new Tenant(timestamp);
	}
	
	/*
	 * Tenant object 
	 */

	public Tenant getTenant(){
		return tenant;
	}
}
