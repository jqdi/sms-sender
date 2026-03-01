package io.github.jqdi.smssender.springbootdemo.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.github.jqdi.smssender.springbootdemo.entity.SmsRecord;
import io.github.jqdi.smssender.springbootdemo.mapper.SmsRecordMapper;

@Service
public class SmsRecordService extends ServiceImpl<SmsRecordMapper, SmsRecord> {
}
