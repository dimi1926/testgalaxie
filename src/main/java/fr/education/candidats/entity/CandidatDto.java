package fr.education.candidats.entity;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement
public class CandidatDto {
	private Long id;
	private String nom;
	private String prenom;
	private String numcan;
	// private Date dtNaissance;
	// private Date dtInscription;
	// private Boolean estQualified;
}
