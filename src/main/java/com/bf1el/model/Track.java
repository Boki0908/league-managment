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
@Table(name="track")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "trk_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long trkId;
		
		@Column(name = "trk_name")
		private String trkName;
		
		@JoinColumn(name = "trk_cnt_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private Nationality nationality;
		
		@Column(name = "trk_city")
		private String trkCity;
		
		@Column(name = "trk_length")
		private Double trkLength;
		
		@Column(name = "trk_laps")
		private Integer trkLaps;
		
}