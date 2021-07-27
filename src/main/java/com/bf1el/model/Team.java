package com.bf1el.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.bf1el.dto.TeamsDrivers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="team")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)


@SqlResultSetMapping(name="customTeamsMapping", 
classes = {
		@ConstructorResult (
				targetClass= TeamsDrivers.class,
				columns = {@ColumnResult(name="teamId", type = Long.class),
						@ColumnResult(name="teamName", type = String.class),
						@ColumnResult(name="driverFirstName", type = String.class),
						@ColumnResult(name="driverLastName", type = String.class),
						@ColumnResult(name="driversFlag", type = String.class)})  
})

@NamedNativeQuery(name = "Team.getAllTeamsWithDrivers" , resultSetMapping = "customTeamsMapping", 
query = "SELECT\r\n"
		+ "team.team_id as teamId, \r\n"
		+ "		team.team_name as teamName,\r\n"
		+ "		driver.drv_first_name as driverFirstName,\r\n"
		+ "        driver.drv_last_name as driverLastName,\r\n"
		+ "        nationality.nat_flag as driversFlag\r\n"
		+ "		\r\n"
		+ "		FROM team \r\n"
		+ "		INNER JOIN driver ON driver.drv_team_id=team.team_id\r\n"
		+ "        INNER JOIN nationality ON nationality.nat_id=driver.drv_nat_id" )




public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name = "team_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long teamId;
		
		@Column(name = "team_name")
		private String teamName;
		
		@Column(name = "team_color")
		private String teamColor;
		
		@JoinColumn(name = "team_engine_supplier")
		@ManyToOne(fetch = FetchType.EAGER)
		private EngineSupplier engineSupplier;
		
		@Column(name = "team_founded")
		private Date teamFounded;
		
		@JoinColumn(name = "team_nat_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private Nationality nationality;
		
		@Column(name = "team_logo")
		private String teamLogo;
		
		@Column(name = "team_pts")
		private Long teamPoints;
		
}
