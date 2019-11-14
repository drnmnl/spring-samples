package com.drnmnl.devtests;

import com.drnmnl.devtests.datetime.DateTimeSample;
import com.drnmnl.devtests.streams.StreamSample;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevtestsApplication {

	public static void main(String[] args) {

		SpringApplication.run(DevtestsApplication.class, args);
		StreamSample ss = new StreamSample();
		ss.demoLambda();

		DateTimeSample dts = new DateTimeSample();
		dts.demoLocalDateTime();
	}

}
