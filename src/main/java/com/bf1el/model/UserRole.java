package com.bf1el.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="userrole")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRole implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "usrr_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long usrrId;
		
		@JoinColumn(name = "usrr_user_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private User user;
		
		@JoinColumn(name = "usrr_role_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private Role role;
			
}