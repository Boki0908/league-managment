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
@Table(name="results")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "res_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long resId;
		
		@JoinColumn(name = "res_trk_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private Track track;
		
		@JoinColumn(name = "res_race_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private Session race;
		
		@Column(name = "res_position1")
		private Integer resPosition1;
		
		@Column(name = "res_position2")
		private Integer resPosition2;
		
		@Column(name = "res_position3")
		private Integer resPosition3;
		
		@Column(name = "res_position4")
		private Integer resPosition4;
		
		@Column(name = "res_position5")
		private Integer resPosition5;
		
		@Column(name = "res_position6")
		private Integer resPosition6;
		
		@Column(name = "res_position7")
		private Integer resPosition7;
		
		@Column(name = "res_position8")
		private Integer resPosition8;
		
		@Column(name = "res_position9")
		private Integer resPosition9;
		
		@Column(name = "res_position10")
		private Integer resPosition10;
		
		@Column(name = "res_position11")
		private Integer resPosition11;
		
		@Column(name = "res_position12")
		private Integer resPosition12;
		
		@Column(name = "res_position13")
		private Integer resPosition13;
		
		@Column(name = "res_position14")
		private Integer resPosition14;
		
		@Column(name = "res_position15")
		private Integer resPosition15;
		
		@Column(name = "res_position16")
		private Integer resPosition16;
		
		@Column(name = "res_position17")
		private Integer resPosition17;
		
		@Column(name = "res_position18")
		private Integer resPosition18;
		
		@Column(name = "res_position19")
		private Integer resPosition19;
		
		@Column(name = "res_position20")
		private Integer resPosition20;
		
		@Column(name = "res_fastest_lap")
		private String resFastestLap;
		
		@JoinColumn(name = "res_fastest_lap_drv_name")
		@ManyToOne(fetch = FetchType.EAGER)
		private Driver fastestLapDriver;
}
