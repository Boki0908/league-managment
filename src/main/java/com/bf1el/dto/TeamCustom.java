package com.bf1el.dto;

import java.util.Date;
import java.util.List;

import com.bf1el.model.EngineSupplier;
import com.bf1el.model.Nationality;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import com.bf1el.model.Driver;

@Data
@AllArgsConstructor
@Builder
public class TeamCustom {
	
	private Long teamId;
	private String teamName;
	private String teamColor;
	private EngineSupplier engineSupplier;
	private Date teamFounded;
	private Nationality nationality;
	private String teamLogo;
	private List<DriverCustom>drivers;
}
