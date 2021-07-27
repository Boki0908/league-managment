package com.bf1el.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bf1el.common.CustomRepository;
import com.bf1el.dto.TeamsDrivers;
import com.bf1el.model.Team;


@Repository
public interface TeamsRepository extends CustomRepository<Team, Long>	 {

	Team findOneByTeamName(String name);

	Optional<Team> findById(Long id);

	Team save(Team team);

	List<Team> findAll();
	
	
	@Query(nativeQuery = true)
	List<TeamsDrivers> getAllTeamsWithDrivers();
	
	
	@Query(value = "SELECT * FROM bf1el_db.team order by team_pts desc;", nativeQuery=true)
	List<Team> getAllTeamsWithOrderByPts();
}
