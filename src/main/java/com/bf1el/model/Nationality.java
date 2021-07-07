package com.bf1el.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name="nationality")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nationality implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "nat_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long natId;
		
		@Column(name = "nat_name")
		private String natName;
		
		@Column(name = "nat_code")
		private String natCode;
		
		@Column(name = "nat_flag")
		private String natFlag;
		

}

