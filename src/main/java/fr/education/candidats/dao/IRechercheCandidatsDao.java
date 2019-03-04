package fr.education.candidats.dao;

import java.util.List;

import fr.education.candidats.entity.Candidat;

public interface IRechercheCandidatsDao {
	List<Candidat> findAllCandidats();
}
