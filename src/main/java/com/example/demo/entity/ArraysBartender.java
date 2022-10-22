package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "arrays")
public class ArraysBartender {
	@Id
	private Integer id;
	@Column(name = "input_array")
	private String inputArray;

}
