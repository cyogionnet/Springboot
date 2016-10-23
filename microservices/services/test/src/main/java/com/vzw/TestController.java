package com.vzw;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/{user}")
	public String hello(@PathVariable  String user) {
		return "Hello " + user;
	}
	
	@RequestMapping("/dummy")
	public String dummyVision() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><service><serviceHeader><billingSys>VISION</billingSys><clientId>VZW-INTERNETSERVICES</clientId><userId>00057234</userId><password>01VISION</password><serviceName>mtnDetailInquiry</serviceName></serviceHeader><serviceBody><serviceRequest><subServiceName>retrieveMtnDetailsWithDaccEquipCodesAndPromo</subServiceName><mtn>9492336482</mtn><accountLevelPlanInfoFlag>Y</accountLevelPlanInfoFlag><campaignCheckCode>Y</campaignCheckCode></serviceRequest></serviceBody></service>";
		return xml;
	}	

}
