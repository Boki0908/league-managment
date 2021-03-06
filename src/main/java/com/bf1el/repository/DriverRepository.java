package com.bf1el.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bf1el.common.CustomRepository;
import com.bf1el.model.Driver;


@Repository
public interface DriverRepository extends CustomRepository<Driver, Long>	 {

	Driver findOneByDrvUsername(String name);

	Optional<Driver> findById(Long id);
// promenio sam umesto long id sam napisao drvId i dole umesto driver user sam ispravio na driver driver
	Driver save(Driver driver);

	List<Driver> findAll();
	
	//random query kojim sortiramo vozace order by ime kolone desc- na nize
	@Query(value= "select *from driver order by drv_points desc", nativeQuery = true)
	List<Driver> findDriversByStandings();
}
