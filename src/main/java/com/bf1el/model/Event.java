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
@Table(name="event")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "eve_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long eveId;
		
		@JoinColumn(name = "eve_track_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private Track track;
		
		@JoinColumn(name = "eve_qualifcation")
		@ManyToOne(fetch = FetchType.EAGER)
		private Session qualifcation;
		
		@JoinColumn(name = "eve_race")
		@ManyToOne(fetch = FetchType.EAGER)
		private Session race;
		
		@Column(name = "eve_round")
		private Integer eveRound;
		
		@Column(name = "eve_name")
		private String eveName;
}
