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
@Table(name="role")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "rol_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long rolId;
		
		@Column(name = "rol_name")
		private String rolName;
		
		
		
}
