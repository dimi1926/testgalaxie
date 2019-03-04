package fr.education.candidats;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value= "/candidats", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Candidat> findAll() throws Exception {		
		return service.findAllCandidats();

	}

	@GetMapping("/candidatsQualifies")
	@CrossOrigin(origins = "http://localhost:4200")
	public Collection<Candidat> findQualifies() throws Exception {
		return service.findAllCandidats().stream().filter(this::isQualified).collect(Collectors.toList());
	}

	private boolean isQualified(Candidat candidat) {
		return candidat.getEstQualified().equals(true);

	}

}
