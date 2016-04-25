package com.qio.model.asset.helper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.qio.model.asset.AssetRequest;
import com.qio.model.assetType.AssetType;
import com.qio.model.tenant.Tenant;
//import com.qio.testHelper.AssetTypeTestHelper;
//import com.qio.testHelper.TenantTestHelper;


//import com.qio.testHelper.AssetTypeTestHelper;
//import com.qio.testHelper.TenantTestHelper;


public class AssetRequestHelper {
	AssetRequest asset;
	
	//putting back
	// private AssetTypeTestHelper assetTypeTestHelper;
	private AssetType responseAssetType;
	private String assetTypeId;
	
	//putting back
	// private TenantTestHelper tenantTestHelper;
	private Tenant responseTenant;
	private String tenantId;
	
	final static Logger logger = Logger.getRootLogger();

	// creates an asset that links to an assetType and tenant.
	private void initDefaultAsset() {
		assetTypeId="";
		tenantId="";
		
		java.util.Date date= new java.util.Date();
		String timestamp = Long.toString(date.getTime());
		asset = new AssetRequest(timestamp, assetTypeId, tenantId);
	}

	public AssetRequest getAssetCreateDependencies(String assetTypeFlavor)throws JsonGenerationException, JsonMappingException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//Create Asset Type
		responseAssetType = new AssetType();	
		// responseAssetType =
		// assetTypeTestHelper.createAssetType(assetTypeFlavor);
		
		String[] assetTypeHrefLinkSplitArray = (responseAssetType.get_links().getSelfLink().getHref()).split("/");
		assetTypeId = assetTypeHrefLinkSplitArray[assetTypeHrefLinkSplitArray.length - 1];
					
		//Create Tenant
		responseTenant = new Tenant();
		// responseTenant = tenantTestHelper.createTenant();
		
		initDefaultAsset();
		asset.setAssetType(assetTypeId);
		asset.setTenant(responseTenant.getTenantId());
		
		logger.info("assetTypeId "+assetTypeId + " tenantId " + responseTenant.getTenantId());
		return asset;
	}

	public AssetRequest getAssetWithPredefinedAssetTypeAndTenant(String assetTypeId, String tenantId) {
		initDefaultAsset();
		asset.setAssetType(assetTypeId);
		asset.setTenant(tenantId);
		return asset;
	}
}