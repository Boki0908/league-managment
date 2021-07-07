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
@Table(name="session")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session implements Serializable {

	private static final long serialVersionUID = 1L;
		
		@Id
		@Column(name = "ses_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long sesId;
		
		@Column(name = "ses_weather")
		private String sesWeather;
		
		@Column(name = "ses_date")
		private Date sesDate;
		
		@Column(name = "ses_type")
		private String sesType;
		
		@JoinColumn(name = "ses_res_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private Results res;
}
