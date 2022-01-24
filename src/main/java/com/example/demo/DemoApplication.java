package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
	}
}
