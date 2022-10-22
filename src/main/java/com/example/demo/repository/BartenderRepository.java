package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ArraysBartender;

public interface BartenderRepository extends JpaRepository<ArraysBartender, Integer> {

}
