package com.vzw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TestService {
	
	@Value("${vision_url:default}")
	private String visionUrl;
	
	@HystrixCommand(fallbackMethod = "stubVisionServiceResponse")
	public String getResponse() {
		RestTemplate restTemplate = new RestTemplate();
		String xml = "?xmlreqdoc=<?xml version=\"1.0\" encoding=\"UTF-8\"?><service><serviceHeader><billingSys>VISION</billingSys><clientId>VZW-INTERNETSERVICES</clientId><userId>00057234</userId><password>01VISION</password><serviceName>mtnDetailInquiry</serviceName></serviceHeader><serviceBody><serviceRequest><subServiceName>retrieveMtnDetailsWithDaccEquipCodesAndPromo</subServiceName><mtn>9492336482</mtn><accountLevelPlanInfoFlag>Y</accountLevelPlanInfoFlag><campaignCheckCode>Y</campaignCheckCode></serviceRequest></serviceBody></service>";
		ResponseEntity<String> response = restTemplate.getForEntity(visionUrl, String.class);
		//ResponseEntity<String> response = restTemplate.getForEntity(visionURL + xml, String.class);
		String responseXML = response.getBody();
		return responseXML;
	}
	
	public String stubVisionServiceResponse() {
		return "Vision Service is down";
	}

}
