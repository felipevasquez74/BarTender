package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ArraysBartender;

@Repository
public interface BartenderRepository extends JpaRepository<ArraysBartender, Integer> {

}
