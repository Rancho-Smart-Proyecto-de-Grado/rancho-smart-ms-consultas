package com.rancho_smart.ms_consultas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsConsultasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsConsultasApplication.class, args);
	}

}
