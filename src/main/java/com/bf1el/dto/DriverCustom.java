package com.bf1el.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DriverCustom {

	private String driverFirstName;
	private String driverLastName;
	private String driversFlag;
}
