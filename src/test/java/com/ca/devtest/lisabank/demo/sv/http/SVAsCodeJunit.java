package com.ca.devtest.lisabank.demo.sv.http;

import com.ca.devtest.sv.devtools.DevTestClient;
import com.ca.devtest.sv.devtools.services.VirtualServiceInterface;
import com.ca.devtest.sv.devtools.services.builder.v3.VirtualServiceV3Builder;
import com.ca.devtest.sv.devtools.services.v3.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.io.File;

public class SVAsCodeJunit {
	static final Log logger = LogFactory.getLog(SVAsCodeJunit.class);
	@Test
	public void testAPI() throws Exception {
		File rrpairsFolder = new File((SVAsCodeJunit.class.getProtectionDomain().getCodeSource().getLocation().getPath()
				+ "../../urFiles" + File.separatorChar + "rrpair").replaceAll("%20", " "));
		System.out.println(rrpairsFolder.getAbsolutePath());
		// Create
		DevTestClient devtest = new DevTestClient("http", "10.252.213.144", "VSE", "admin", "admin", "demo", "", "");

		// Virtual Service builder
		VirtualServiceV3Builder v3VSBuilder = devtest.withV3API("rrpairVS1", rrpairsFolder);
		v3VSBuilder.setInputFile1("Op8andOp9-RRPairs.zip");

		// build Transport Protocol
		Config configObject = Config.ConfigBuilder.builder()
				.withVirtualService(
						VirtualService.VirtualServiceBuilder.builder().withName(v3VSBuilder.getDeployedName()).build())
				.withTransportProtocol(TransportProtocol.TransportProtocolBuilder
						.builder().withBasePath("/").withRecordingEndpoint(Endpoint.EndpointBuilder.builder()
								.withPort("18082").withSSLConfig(SSLConfig.SSLConfigBuilder.builder().build()).build())
						.build()

				).build();

		v3VSBuilder.setConfig(ConfigObjectBuilder.convertToJson(configObject));
		VirtualServiceInterface sv = v3VSBuilder.build();
		// Deploy VS
		sv.deploy();
		// unDeploy VS
		
		//Write Some Logic to test the API and then undeploy
		//sv.unDeploy();
	}

//	@Test
//	public void demoVSCreationRRPair() throws Exception {
//		File rrpairsFolder = new File((SVAsCodeJunit.class.getProtectionDomain().getCodeSource().getLocation().getPath()
//				+ "..\\..\\v3" + File.separatorChar + "rrpair").replaceAll("%20", " "));
//
//		// Create
//		DevTestClient devtest = new DevTestClient("http", "localhost", "VSE", "svpower", "svpower", "demo2", "", "");
//
//		// Virtual Service builder
//		VirtualServiceV3Builder v3VSBuilder = devtest.withV3API("myservice4", rrpairsFolder);
//		v3VSBuilder.setInputFile1("operation-8-req.txt");
//		v3VSBuilder.setInputFile2("operation-8-rsp.txt");
//		v3VSBuilder.setConfig("{\"virtualService\":{\"version\":\"1.0\",\"name\":\"" + v3VSBuilder.getDeployedName()
//				+ "\",\"description\":\"Deployed using SV-as-Code\",\"status\":\"\",\"capacity\":0,\"thinkScale\":0,\"autoRestart\":true,\"startOnDeploy\":true,\"groupTag\":\"\"},\"transportProtocol\":{\"typeId\":\"HTTP\",\"basePath\":\"/\",\"useGateway\":false,\"hostHeaderPassThrough\":false,\"recordingEndpoint\":{\"useSSL\":false,\"host\":\"\",\"port\":\"38081\"}}}");
//		VirtualServiceInterface sv = v3VSBuilder.build();
//		// Deploy VS
//		sv.deploy();
//	}
//	
//	@Test
//	public void demoVSSwagger() throws Exception {
//		File rrpairsFolder = new File((SVAsCodeJunit.class.getProtectionDomain().getCodeSource().getLocation().getPath()
//				+ "..\\..\\v3" + File.separatorChar + "swagger").replaceAll("%20", " "));
//
//		// Create
//		DevTestClient devtest = new DevTestClient("http", "localhost", "VSE", "admin", "admin", "demo3", "", "");
//
//		// Virtual Service builder
//		VirtualServiceV3Builder v3VSBuilder = devtest.withV3API("swaggerVS", rrpairsFolder);
//		v3VSBuilder.setInputFile1("swagger.json");
//
//		// build Transport Protocol
//		Config configObject = Config.ConfigBuilder.builder()
//				.withVirtualService(
//						VirtualService.VirtualServiceBuilder.builder().withName(v3VSBuilder.getDeployedName()).build())
//				.withTransportProtocol(TransportProtocol.TransportProtocolBuilder
//						.builder().withBasePath("/").withRecordingEndpoint(Endpoint.EndpointBuilder.builder()
//								.withPort("28084").withSSLConfig(SSLConfig.SSLConfigBuilder.builder().build()).build())
//						.build()
//
//				).build();
//
//		v3VSBuilder.setConfig(ConfigObjectBuilder.convertToJson(configObject));
//		VirtualServiceInterface sv = v3VSBuilder.build();
//		// Deploy VS
//		sv.deploy();
//	}
//	
//	@Test
//	public void demoVSWADL() throws Exception {
//		File rrpairsFolder = new File((SVAsCodeJunit.class.getProtectionDomain().getCodeSource().getLocation().getPath()
//				+ "..\\..\\v3" + File.separatorChar + "wadl").replaceAll("%20", " "));
//
//		// Create
//		DevTestClient devtest = new DevTestClient("http", "localhost", "VSE", "admin", "admin", "demo3", "", "");
//
//		// Virtual Service builder
//		VirtualServiceV3Builder v3VSBuilder = devtest.withV3API("vsWADL", rrpairsFolder);
//		v3VSBuilder.setInputFile1("os-services.wadl");
//
//		// build Transport Protocol
//		Config configObject = Config.ConfigBuilder.builder()
//				.withVirtualService(
//						VirtualService.VirtualServiceBuilder.builder().withName(v3VSBuilder.getDeployedName()).build())
//				.withTransportProtocol(TransportProtocol.TransportProtocolBuilder
//						.builder().withBasePath("/").withRecordingEndpoint(Endpoint.EndpointBuilder.builder()
//								.withPort("28085").withSSLConfig(SSLConfig.SSLConfigBuilder.builder().build()).build())
//						.build()
//
//				).build();
//
//		v3VSBuilder.setConfig(ConfigObjectBuilder.convertToJson(configObject));
//		VirtualServiceInterface sv = v3VSBuilder.build();
//		// Deploy VS
//		sv.deploy();
//	}
//
//	@Test
//	public void undeployVS() throws Exception {
//
//		File rrpairsFolder = new File("file1.txt");
//		// Create
//		DevTestClient devtest = new DevTestClient("http", "localhost", "VSE", "admin", "admin", "demo3", "", "");
//		// Virtual Service builder
//		VirtualServiceV3Builder v3VSBuilder = devtest.withV3API("swaggerVS", rrpairsFolder);
//		VirtualServiceInterface sv = v3VSBuilder.build();
//		sv.unDeploy();
//	}
}
