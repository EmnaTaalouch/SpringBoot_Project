package tn.esprit.services.Interfaces;
import java.util.List;
import java.util.Set;

import tn.esprit.persistance.Mission;

public interface MissionService {
	List<Mission> retrieveAllMissions();

	Mission addMission (Mission m);

	Mission updateMission (Mission m);

	Mission retrieveMission(Integer idMission);
	
	List<Mission> retrieveMissionsByContrat(Integer idContrat);

	void removeMission(Integer idMission);
	
    
	public void assignMissionToContrat (Integer missionId, Integer contratId) ;
}



