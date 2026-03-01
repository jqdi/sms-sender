package io.github.jqdi.smssender.springbootdemo.amqp.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jqdi.smssender.springbootdemo.amqp.core.BaseStrategy;
import io.github.jqdi.smssender.springbootdemo.amqp.strategy.dto.SendSmsMQDto;
import io.github.jqdi.smssender.springbootdemo.sms.SmsSenderConsumer;

@Component(StrategyConstants.SENDSMS_STRATEGY)
public class SendSmsStrategy implements BaseStrategy<SendSmsMQDto> {

	@Autowired
	private SmsSenderConsumer amsSenderConsumer;

	@Override
	public void doStrategy(SendSmsMQDto params) {
		Integer smsTaskDetailId = params.getSmsTaskDetailId();
		amsSenderConsumer.consumer(smsTaskDetailId);
	}
}
