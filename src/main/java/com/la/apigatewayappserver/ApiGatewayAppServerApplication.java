/**
 * https://medium.com/bliblidotcom-techblog/spring-cloud-gateway-dynamic-routes-from-database-dc938c6665de
 * https://piotrminkowski.com/2019/11/06/microservices-with-spring-boot-spring-cloud-gateway-and-consul-cluster/
 * https://www.marcobehler.com/guides/spring-security
 */
package com.la.apigatewayappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableDiscoveryClient
//@Configuration
//@EnableAutoConfiguration
//@EnableWebSecurity

//@ComponentScans({ @ComponentScan("com.eazybytes.controller"), @ComponentScan("com.eazybytes.config")})
@EnableJpaRepositories("com.la.apigatewayappserver.repository")
@EntityScan("com.la.apigatewayappserver.models")

public class ApiGatewayAppServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayAppServerApplication.class, args);
	}

}
