package fr.education.candidats.service;
import java.util.List;

import fr.education.candidats.entity.Candidat;

public interface ICandidatService {
	List<Candidat> findAllCandidats() throws Exception;

}
