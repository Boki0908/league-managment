package com.bf1el.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bf1el.common.CustomRepository;
import com.bf1el.model.Nationality;
@Repository
public interface NationalityRepository extends CustomRepository<Nationality, Long>{

	List<Nationality> findAll();
}
