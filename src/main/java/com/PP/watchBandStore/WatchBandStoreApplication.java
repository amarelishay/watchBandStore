package com.PP.watchBandStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class WatchBandStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchBandStoreApplication.class, args);
	}

}
