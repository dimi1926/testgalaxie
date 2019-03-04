package fr.education.candidats.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.education.candidats.entity.Candidat;

//@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
@Component
@Transactional
public class CandidatDao implements IRechercheCandidatsDao {
	private final String ALL_CANDIDATS = "SELECT c FROM Candidat c ORDER BY nom ASC";

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Candidat> findAllCandidats() {
		return entityManager.createQuery(ALL_CANDIDATS, Candidat.class).getResultList();
	}

}
