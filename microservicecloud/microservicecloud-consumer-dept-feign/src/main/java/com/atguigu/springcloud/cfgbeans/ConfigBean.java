package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced//负载均衡
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule() {
		//return new RandomRule();//负载均衡选择随机算法，在Ribon中，负载均衡选择什么样的算法，只需要new一下相对应的类就行
		return new RetryRule();//先执行轮询算法，如果有一个服务挂了，则依然会执行几次轮询，
		//等执行多次之后，挂掉的服务依然挂了，则会绕开该服务，如果挂掉的服务重启之后，则依然会执行轮询
	}
}
