package Micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import Micro.filters.*;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GameGrabZuulWithDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameGrabZuulWithDiscoveryApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	@Bean 
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean 
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
}
