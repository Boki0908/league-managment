package com.bf1el.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.bf1el.common.EntityNotFoundException;
import com.bf1el.dto.DriverCustom;
import com.bf1el.dto.TeamCustom;
import com.bf1el.dto.TeamsDrivers;
import com.bf1el.model.Driver;
import com.bf1el.model.Team;

import com.bf1el.repository.TeamsRepository;



@Service
public class TeamsService {
	
	@Autowired
	private TeamsRepository teamsRepository;
	
	//Dependency Injection ostvarujemo kroz konstruktor. Injectujemo repository u servis
	@Autowired
	public TeamsService(TeamsRepository teamsRepository) {
		this.teamsRepository = teamsRepository;
	}
	
	public List<Team>getAll(){
		return teamsRepository.findAll();
	}
	
	public Team findById(Long id) {
		Optional<Team> team = teamsRepository.findById(id);
		if(!team.isPresent()) {
			throw new EntityNotFoundException("Team with id:" + id + " doesn't exists."); 
		}
		return team.get();
	}
	
	@Transactional
	public Team create(Team team) {
		
		
		Team tm = teamsRepository.save(team);
		return tm;
		
	}
	
	public List<TeamCustom> getCustomTeams(){
		List<Team> teams = teamsRepository.findAll();
		List<TeamsDrivers> teamsDrivers = teamsRepository.getAllTeamsWithDrivers();
		List<TeamCustom> teamCustom = new ArrayList<TeamCustom>();
		
		//forEach petlja se koristi za prolazak kroz Listu<Object>
		// prvi parametar je tip Objekta - u ovom slucaju Team, drugi-param je proizvoljno ime, : treci- popunjena lista 
		// u nasem slucaju teams
		for(Team team: teams) {
			TeamCustom customTeam = this.populateTeamsCustom(team, teamsDrivers);
			teamCustom.add(customTeam);
		}
		
		return teamCustom;
	}
	
	//metoda popunjava vozace za tim koji je poslat kao prvi parametar ove metode
	//drugi parametar ove metode je cela ona lista vozaca 
	private TeamCustom populateTeamsCustom(Team team, List<TeamsDrivers> teamsDrivers) {
		
		// napravljena prazna lista u koju smestamo ove custom drivere
		List<DriverCustom> drivers = new ArrayList<>();
		
		//posebvna provera da slucajno lista nije prazna ili null pa da ne pukne program
		//StringUtils je biblioteka koja nam daje mnogo pomoci za obradu Stringova, Listi itd...
		if(!StringUtils.isEmpty(teamsDrivers)) {
			for(TeamsDrivers drv : teamsDrivers) {
				
				//Builder nam pomaze da ne moramo da pisemo
				// DriverCustom driver = new DriverCustom();
				// driver.setDriverName = "sasads";
				// nego samo odmah nad klasom DriverCustom gradim kroz builder metodu ceo objekat
				// na kraju kad sam popunio sve parametre tog objekta izvrsava build().
				
				
				if(drv.getTeamId() == team.getTeamId()) {
					drivers.add(DriverCustom.builder()
							.driverFirstName(drv.getDriverFirstName())
							.driverLastName(drv.getDriverLastName())
							.driversFlag(drv.getDriversFlag())
							.build());
				}
					
			}
		}
		
		return TeamCustom.builder()
				.teamId(team.getTeamId())
				.teamName(team.getTeamName())
				.drivers(drivers)
				.engineSupplier(team.getEngineSupplier())
				.nationality(team.getNationality())
				.teamColor(team.getTeamColor())
				.teamFounded(team.getTeamFounded())
				.teamLogo(team.getTeamLogo())
				.build();
	}
}
