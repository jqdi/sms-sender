package io.github.jqdi.smssender.springbootdemo.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.github.jqdi.smssender.springbootdemo.entity.SmsTypeTemplateConfig;
import io.github.jqdi.smssender.springbootdemo.mapper.SmsTypeTemplateConfigMapper;

@Service
public class SmsTypeTemplateConfigService extends ServiceImpl<SmsTypeTemplateConfigMapper, SmsTypeTemplateConfig> {

	public SmsTypeTemplateConfig selectByTypeChannel(String type, String channel) {
		return baseMapper.selectByTypeChannel(type, channel);
	}
}
