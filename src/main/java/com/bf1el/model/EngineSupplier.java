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
@Table(name="enginesupplier")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineSupplier implements Serializable {

	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "eng_id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long engId;
		
		@Column(name = "eng_name")
		private String engName;
		
		@Column(name = "eng_hp")
		private Double engHp;
		
		@JoinColumn(name = "eng_nat_id")
		@ManyToOne(fetch = FetchType.EAGER)
		private Nationality nationality;
		
		@Column(name = "eng_hibrid")
		private Boolean engHibrid;
}
