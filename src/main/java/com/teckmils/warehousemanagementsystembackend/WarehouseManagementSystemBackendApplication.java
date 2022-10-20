package com.teckmils.warehousemanagementsystembackend;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class WarehouseManagementSystemBackendApplication {

	private static final Logger logger =
			LoggerFactory.getLogger(WarehouseManagementSystemBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WarehouseManagementSystemBackendApplication.class, args);
		logger.info("Application Started");
	}

}
