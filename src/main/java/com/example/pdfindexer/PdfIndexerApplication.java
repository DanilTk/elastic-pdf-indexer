package com.example.pdfindexer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(basePackages = "com.example.pdfindexer.*")
@SpringBootApplication
public class PdfIndexerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfIndexerApplication.class, args);
	}

}
