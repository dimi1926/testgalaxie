package fr.education.candidats.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@XmlRootElement
@Table(name = "candidat")
@NamedQueries(value= {
		@NamedQuery(name="Candidat.findByNumcan", 
				query="SELECT c FROM Candidat c WHERE c.numcan = :numcan")
		
})
public class Candidat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nom")
	private @NonNull String nom;
	@Column(name = "prenom")
	private @NonNull String prenom;
	@Column(name = "numcan")
	private @NonNull String numcan;
	@Column(name = "dt_naissance")
	private @NonNull Date dtNaissance;
	@Column(name = "dt_inscription")
	private Date dtInscription;
	@Column(name = "est_qualifie")
	private Boolean estQualified;

}
