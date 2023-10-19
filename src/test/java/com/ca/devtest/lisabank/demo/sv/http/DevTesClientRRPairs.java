
package com.ca.devtest.lisabank.demo.sv.http;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.ca.devtest.sv.devtools.annotation.v3.DevTestVirtualServiceV3;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;

import com.ca.devtest.sv.devtools.annotation.Config;
import com.ca.devtest.sv.devtools.annotation.DevTestVirtualServer;
import com.ca.devtest.sv.devtools.annotation.DevTestVirtualService;
import com.ca.devtest.sv.devtools.annotation.DevTestVirtualServiceFromVrs;
import com.ca.devtest.sv.devtools.annotation.Parameter;
import com.ca.devtest.sv.devtools.annotation.Protocol;
import com.ca.devtest.sv.devtools.annotation.ProtocolType;
import com.ca.devtest.sv.devtools.application.SoapClient;
import com.ca.devtest.sv.devtools.junit.VirtualServicesRule;

/**
 * @author 
 *
 */
@DevTestVirtualServer(registryHost = "10.252.213.144", deployServiceToVse = "VSE")
public class DevTesClientRRPairs {
	
	@Rule
	public VirtualServicesRule rules = new VirtualServicesRule();
	
	

	/**
	 * @throws IOException
	 * @throws URISyntaxException
	 */


	@DevTestVirtualServiceV3(serviceName = "svascode",
			port = "9001",
			basePath = "/lisa",
			workingFolder = "rrpairs/soap",
			inputFile2 = "getUser-req.xml",
			inputFile1 = "getUser-rsp.xml"
	)
	@Test
	public void createSoapServiceV3() throws IOException, URISyntaxException {
		System.out.println("Sv as code Demo - 1");
		System.out.println("Sv as code Demo - 2");
		
	}

}
