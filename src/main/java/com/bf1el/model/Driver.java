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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

// Entity predstavlja dakle entitet Driver koji ce biti sacuvan u DB
// Ova klasa je model koji predstavlja tabelu driver
@Entity
@Table(name = "driver")
//lombok bilbiotkea koja pravi automatski getere , setere i procitaj na netu sta jos.
@Data
// lombok anotacija za konstruktor bez parametara
//ignorise dodatne json propertije u requestu
@JsonIgnoreProperties(ignoreUnknown = true)
public class Driver implements Serializable {
	
	public Driver () {}
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Id
	@Column(name = "drv_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long drvId;
	
	@Column(name = "drv_first_name")
	private String drvFirstName;
	
	@Column(name = "drv_last_name")
	private String drvLastName;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name = "drv_birth_date")
	private Date drvBirthDate;
	
	@JoinColumn(name = "drv_nat_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Nationality nationality;
	
	@Column(name = "drv_username")
	private String drvUsername;
	
	@Column(name = "drv_points")
	private Integer drvPoints;
	
	@JoinColumn(name = "drv_team_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Team team;
	
	@Column(name = "drv_number")
	private Integer drvNumber;
	
	@Column(name = "drv_wins")
	private Integer drvWins;
	
	@Column(name = "drv_podiums")
	private Integer drvPodiums;

}
