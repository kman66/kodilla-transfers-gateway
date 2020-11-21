package com.kodilla.transfersgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableDiscoveryClient
@SpringBootApplication
public class KodillaTransfersGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(KodillaTransfersGatewayApplication.class, args);
	}

}
