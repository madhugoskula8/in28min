package com.app.routerConfig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfi {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/currency-exchange/**")
						.uri("lb://currency-exchange/"))
				.route(p->p.path("/currency-conversion/**")
						.uri("lb://currency-conversion"))
				.route(p->p.path("/currency-converion-feign/**")
						.uri("lb://currency-converion-feign"))
				.route(p->p.path("/currency-converion-new/**")
						.filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)", 
								"/currency-conversion-feign/${segment}"))
						.uri("lb://currency-conversion"))
				
				.build();
	}

}
