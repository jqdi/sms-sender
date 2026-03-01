package io.github.jqdi.smssender.springbootdemo.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.github.jqdi.smssender.springbootdemo.entity.SmsTemplate;
import io.github.jqdi.smssender.springbootdemo.mapper.SmsTemplateMapper;

@Service
public class SmsTemplateService extends ServiceImpl<SmsTemplateMapper, SmsTemplate> {

	public SmsTemplate selectByChannelTemplateCode(String channel, String templateCode) {
		return baseMapper.selectByChannelTemplateCode(channel, templateCode);
	}
}
