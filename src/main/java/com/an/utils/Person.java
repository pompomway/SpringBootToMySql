package com.an.utils;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor 
@NoArgsConstructor 
@Component 
public class Person {
	@Setter 
	@Getter
	private int pk;
	@Setter 
	@Getter
	private String id;
	@Setter 
	@Getter
	private String pass;

}
