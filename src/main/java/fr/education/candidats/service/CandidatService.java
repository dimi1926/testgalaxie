package fr.education.candidats.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.education.candidats.dao.IRechercheCandidatsDao;
import fr.education.candidats.entity.Candidat;

@Transactional
@Component
public class CandidatService implements ICandidatService {
	@Autowired
	private IRechercheCandidatsDao dao;

	@Override
	public List<Candidat> findAllCandidats() throws Exception {
		return dao.findAllCandidats();
	}

	@Override
	public Candidat findCandidatByNumcan(String id) throws Exception {
		return dao.findCandidatByNumcan(Long.parseLong(id));
	}

}
