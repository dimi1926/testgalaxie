package fr.education.candidats.dao;

import java.util.List;

import fr.education.candidats.entity.Candidat;

public interface IRechercheCandidatsDao {
	List<Candidat> findAllCandidats();
	Candidat findCandidatByNumcan(Long id);
	Candidat saveCan(Integer id, Candidat can);
	void delete(Candidat can);

}
