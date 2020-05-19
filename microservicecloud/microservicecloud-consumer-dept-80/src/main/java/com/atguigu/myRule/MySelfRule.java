package com.atguigu.myRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * 自定义负载均衡的规则
 * @author Administrator
 *
 */
@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule() {
		//return new RandomRule();//默认轮询，改成了随机
//		return new RoundRobinRule();//轮询
		return new RandomRule_ZY();//自定义负载均衡的规则
	}
}
