package com.bf1el.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="driverteam")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverTeam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "drt_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long drtId;
	
	@JoinColumn(name = "drt_drv_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Driver driver;
	
	
	@JoinColumn(name = "drt_team_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Team team;
	
	@Column(name = "drt_tier_number")
	private Integer drtTierNumber;
	
	
}

