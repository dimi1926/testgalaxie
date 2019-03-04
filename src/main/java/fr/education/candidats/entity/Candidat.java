package fr.education.candidats.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "candidat")
public class Candidat {
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
