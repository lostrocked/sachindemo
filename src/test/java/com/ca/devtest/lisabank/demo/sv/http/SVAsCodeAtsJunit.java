package com.ca.devtest.lisabank.demo.sv.http;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.ca.devtest.sv.devtools.annotation.v3.DevTestVirtualServiceV3;
import com.ca.devtest.sv.devtools.annotation.v3.DevTestVirtualServicesV3;

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


@DevTestVirtualServer(deployServiceToVse = "VSE")
public class SVAsCodeAtsJunit {
	
	@Rule
	public VirtualServicesRule rules = new VirtualServicesRule();
	
	
	/**
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	
	@DevTestVirtualServiceV3(serviceName = "lisa",
			port = "9001",
			basePath = "/lisa",
			workingFolder = "",
			inputFile2 = "getUser-req.xml",
			inputFile1 = "getUser-rsp.xml"
	)
	@DevTestVirtualServicesV3()
	@Test
	public void createSoapServiceV3() throws IOException, URISyntaxException {
		int port = 9001;
		String path = "/lisa";
		//System.out.println();
		/* Test */
//		SoapClient soapclient = new SoapClient("localhost", String.valueOf(port));
//		URL url = getClass().getClassLoader().getResource("../../v3/rrpairs/soap/getUser-req.xml");
//		File requestFile = new File(getClass().getClassLoader().getResource("../../v3/rrpairs/soap/getUser-req.xml").toURI());
//		String request = FileUtils.readFileToString(requestFile, "UTF-8");
//		String response = soapclient.callService(path, request);
	}
}
