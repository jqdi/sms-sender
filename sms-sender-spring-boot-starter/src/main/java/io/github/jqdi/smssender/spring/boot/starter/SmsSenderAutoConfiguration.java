package io.github.jqdi.smssender.spring.boot.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import io.github.jqdi.smssender.core.SendPostProcessor;
import io.github.jqdi.smssender.core.SmsSender;
import io.github.jqdi.smssender.core.ali.AliSmsSender;
import io.github.jqdi.smssender.core.baidu.BaiduSmsSender;
import io.github.jqdi.smssender.core.jingdong.JingdongSmsSender;
import io.github.jqdi.smssender.core.log.LogSmsSender;
import io.github.jqdi.smssender.core.qiniu.QiniuSmsSender;
import io.github.jqdi.smssender.core.tencent.TencentSmsSender;
import io.github.jqdi.smssender.spring.boot.starter.properties.AliSmsProperties;
import io.github.jqdi.smssender.spring.boot.starter.properties.BaiduSmsProperties;
import io.github.jqdi.smssender.spring.boot.starter.properties.JingdongSmsProperties;
import io.github.jqdi.smssender.spring.boot.starter.properties.LogSmsProperties;
import io.github.jqdi.smssender.spring.boot.starter.properties.QiniuSmsProperties;
import io.github.jqdi.smssender.spring.boot.starter.properties.TentcentSmsProperties;

@Configuration
@ConditionalOnProperty(prefix = "smssender", name = "active")
@ConditionalOnMissingBean(SmsSender.class)
@EnableConfigurationProperties({ LogSmsProperties.class, AliSmsProperties.class, TentcentSmsProperties.class,
		BaiduSmsProperties.class, JingdongSmsProperties.class, QiniuSmsProperties.class })
public class SmsSenderAutoConfiguration {
	// for test env
	@Bean
	@ConditionalOnProperty(prefix = "smssender", name = "active", havingValue = "log")
	SmsSender logSmsSender(LogSmsProperties properties, @Nullable SendPostProcessor sendPostProcessor) {
		String signName = properties.getSignName();

		SmsSender smsSender = new LogSmsSender(signName, sendPostProcessor);
		return smsSender;
	}
	// for test env

	@Bean
	@ConditionalOnProperty(prefix = "smssender", name = "active", havingValue = "ali")
	SmsSender aliSmsSender(AliSmsProperties properties, @Nullable SendPostProcessor sendPostProcessor) {
		String regionId = properties.getRegionId();
		String accessKey = properties.getAccessKey();
		String secretKey = properties.getSecretKey();
		String signName = properties.getSignName();

		SmsSender smsSender = new AliSmsSender(regionId, accessKey, secretKey, signName, sendPostProcessor);
		return smsSender;
	}

	@Bean
	@ConditionalOnProperty(prefix = "smssender", name = "active", havingValue = "tencent")
	SmsSender tencentSmsSender(TentcentSmsProperties properties, @Nullable SendPostProcessor sendPostProcessor) {
		String appId = properties.getAppId();
		String regionId = properties.getRegionId();
		String accessKey = properties.getAccessKey();
		String secretKey = properties.getSecretKey();
		String signName = properties.getSignName();

		SmsSender smsSender = new TencentSmsSender(appId, regionId, accessKey, secretKey, signName, sendPostProcessor);
		return smsSender;
	}

	@Bean
	@ConditionalOnProperty(prefix = "smssender", name = "active", havingValue = "baidu")
	SmsSender baiduSmsSender(BaiduSmsProperties properties, @Nullable SendPostProcessor sendPostProcessor) {
		String accessKey = properties.getAccessKey();
		String secretKey = properties.getSecretKey();
		String signName = properties.getSignName();

		SmsSender smsSender = new BaiduSmsSender(accessKey, secretKey, signName, sendPostProcessor);
		return smsSender;
	}

	@Bean
	@ConditionalOnProperty(prefix = "smssender", name = "active", havingValue = "jingdong")
	SmsSender jingdongSmsSender(JingdongSmsProperties properties, @Nullable SendPostProcessor sendPostProcessor) {
		String regionId = properties.getRegionId();
		String accessKey = properties.getAccessKey();
		String secretKey = properties.getSecretKey();
		String signName = properties.getSignName();

		SmsSender smsSender = new JingdongSmsSender(regionId, accessKey, secretKey, signName, sendPostProcessor);
		return smsSender;
	}

	@Bean
	@ConditionalOnProperty(prefix = "smssender", name = "active", havingValue = "qiniu")
	SmsSender qiniuSmsSender(QiniuSmsProperties properties, @Nullable SendPostProcessor sendPostProcessor) {
		String accessKey = properties.getAccessKey();
		String secretKey = properties.getSecretKey();
		String signName = properties.getSignName();

		SmsSender smsSender = new QiniuSmsSender(accessKey, secretKey, signName, sendPostProcessor);
		return smsSender;
	}
}
