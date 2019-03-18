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

	@Override
	public List<Candidat> findAllCandidats() {
		return entityManager.createQuery(ALL_CANDIDATS, Candidat.class).getResultList();
	}

	@Override
	public Candidat findCandidatByNumcan(Long id) {
		return entityManager.find(Candidat.class, id);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Candidat saveCan(Integer id, Candidat candidat) {
		Candidat objetBase = findCandidatByNumcan(candidat.getId());
		if (id.equals(objetBase.getId())) {
			entityManager.merge(candidat);
		} else {
			entityManager.persist(candidat);
		}
		return candidat;
	}

	@Override
	public void delete(Candidat can) {
		System.out.println("dans dao id est: "+can.getId());
		entityManager.remove(can);
	}

}
