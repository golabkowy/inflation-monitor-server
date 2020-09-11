package com.inflationmonitor.inflationmonitorserver;

import com.inflationmonitor.inflationmonitorserver.data.entities.Product;
import com.inflationmonitor.inflationmonitorserver.data.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InflationMonitorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InflationMonitorServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner testDBBean(ProductRepository productRepository) {
        return (args -> {
            System.out.println("Bean method invocation test");
            Product product = new Product("test-product");
            productRepository.save(product);
            System.out.println("All DB Records" + productRepository.findAll());
        });


    }
}
