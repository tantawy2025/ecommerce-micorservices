package com.example.customer;

import com.example.customer.repo.CustomerRepository;
import com.example.customer.repo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableDiscoveryClient
public class CustomerServiceApplication  {

	@Autowired
	private  CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

//	@Override
//	public void run(String... args) {
//		// Preload sample data
//		// Ensure the customer exists before adding orders
//		Customer customer = new Customer();
//		customer.setName("tantawy");
//		customer.setBalance(100000);
//
//
//		customerRepository.save(customer);
//	}

}
