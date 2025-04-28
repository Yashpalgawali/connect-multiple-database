package com.example.demo.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.postgres.entity.Company;

@Repository("comprepo")
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
