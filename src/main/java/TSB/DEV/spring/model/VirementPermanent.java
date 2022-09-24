
	package TSB.DEV.spring.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="virementpermanents")
@DiscriminatorValue("P")
public class VirementPermanent extends Virement{
	
	@Column (name="date_debut")
	private String dateDebut;

	@Column (name="date_fin")
	private String dateFin;

	@Column (name="jour_execution")
	private String jourExecution;
	
}