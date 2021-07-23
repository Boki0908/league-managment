package com.bf1el.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamsDrivers {
	
	
	private Long teamId;
	private String teamName;
	private String driverFirstName;
	private String driverLastName;
	private String driversFlag;
	
}
