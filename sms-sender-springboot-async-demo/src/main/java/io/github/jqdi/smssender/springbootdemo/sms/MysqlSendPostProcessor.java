package io.github.jqdi.smssender.springbootdemo.sms;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jqdi.smssender.core.SendPostProcessor;
import io.github.jqdi.smssender.core.SendResponse;
import io.github.jqdi.smssender.springbootdemo.entity.SmsRecord;
import io.github.jqdi.smssender.springbootdemo.service.SmsRecordService;
import io.github.jqdi.smssender.springbootdemo.util.JsonUtil;

@Component
public class MysqlSendPostProcessor implements SendPostProcessor {

	@Autowired
	private SmsRecordService smsRecordService;

	@Override
	public void afterSend(String channel, String mobile, String signName, String templateCode,
			LinkedHashMap<String, String> templateParamMap, String content, SendResponse sendResponse) {

		SmsRecord smsRecord = new SmsRecord();
		smsRecord.setChannel(channel);
		smsRecord.setMobile(mobile);
		smsRecord.setSignName(signName);
		smsRecord.setTemplateCode(templateCode);
		smsRecord.setTemplateParamJson(JsonUtil.toJsonString(templateParamMap));
		smsRecord.setContent(content);

		if (sendResponse.isSuccess()) {
			smsRecord.setResult("success");
		} else {
			smsRecord.setResult("fail");
		}
		smsRecord.setMessage(sendResponse.getMessage());
		smsRecord.setRequestId(sendResponse.getRequestId());
		smsRecordService.insert(smsRecord);
	}
}
