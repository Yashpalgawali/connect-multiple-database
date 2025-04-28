package com.example.demo.mongo.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Document(collection = "department")
@Data
@Builder
public class Department {

	@Id
	private String id;
	
	private String name;
	
}
