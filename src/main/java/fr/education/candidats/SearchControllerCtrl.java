package fr.education.candidats;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.education.candidats.entity.Candidat;
import fr.education.candidats.service.ICandidatService;

@RestController
public class SearchControllerCtrl {
	@Autowired
	private ICandidatService service;

	public SearchControllerCtrl(ICandidatService iCandidatService) {
		this.service = iCandidatService;
	}

	@RequestMapping(value = "/candidats", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Candidat> findAll() throws Exception {
		return service.findAllCandidats();

	}

	// localhost:8080/ws/candidats/details?numcan="132454"
	@RequestMapping(value = "/candidats/details", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Candidat findCandidatByNumcan(@RequestParam("id") String id) throws Exception {
		return service.findCandidatByNumcan(id);
	}

	@GetMapping("/candidatsQualifies")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Candidat> findQualifies() throws Exception {
		return service.findAllCandidats().stream().filter(this::isQualified).collect(Collectors.toList());
	}

//	@RequestMapping(value = "/candidats/save", method = RequestMethod.POST)
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Candidat sauvegarderCandidat(@RequestBody Candidat candidat) throws Exception {
//		return service.sauvegarderCandidat(candidat);
//	}

	@RequestMapping(value = "/candidats/save", method = RequestMethod.PUT)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@CrossOrigin(origins = "*")
	public Candidat save(@RequestBody Candidat candidat) {
		Candidat candidatBase = null;
		System.out.println("ici cest l'id: " + candidat.toString());

		try {
			candidatBase = service.findCandidatByNumcan(String.valueOf(candidat.getId()));
			System.out.println("ici cest l'id: " + candidatBase.getId());
			candidatBase.setNom(candidat.getNom());
			candidatBase.setPrenom(candidat.getPrenom());
			candidatBase.setDtNaissance(candidat.getDtNaissance());

			service.sauvegarderCandidat(candidatBase.getId().intValue(), candidatBase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return candidatBase;
	}

	@RequestMapping(value = "/candidats/delete", method = RequestMethod.DELETE)
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@CrossOrigin(origins = "*")
	public Collection<Candidat> delete(@RequestParam("id") String paramId) throws Exception {
		Candidat candidatBase = null;
		System.out.println("paramId d'angularest l'id: " + paramId);
		candidatBase = service.findCandidatByNumcan(paramId);
		System.out.println("objet dans la bdd a l'id: " + candidatBase.getId());
		service.delete(candidatBase);
		return this.findAll();
	}

	private boolean isQualified(Candidat candidat) {
		return candidat.getEstQualified().equals(true);

	}

}
