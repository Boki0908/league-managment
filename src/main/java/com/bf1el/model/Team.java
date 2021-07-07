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
@Table(name="team")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
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
		
		@Column(name = "team_nat_id")
		private Integer teamNatId;
		
		@Column(name = "team_logo")
		private String teamLogo;
}
