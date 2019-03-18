package fr.education.candidats.service;

import java.util.List;

import fr.education.candidats.entity.Candidat;

public interface ICandidatService {
	List<Candidat> findAllCandidats() throws Exception;

	Candidat findCandidatByNumcan(String id) throws Exception;

	Candidat sauvegarderCandidat(Integer itemId, Candidat can);

	void delete(Candidat can);
}
