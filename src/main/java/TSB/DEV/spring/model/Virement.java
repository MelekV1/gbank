package TSB.DEV.spring.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "virement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@DiscriminatorColumn(name="type_virement")
public class Virement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "montant")
	private long montant;
	
	@Column(name = "nb_virement")
	private long nbVirement;
	
	@Column(name = "rib_beneficiaire")
	private String ribBeneficiaire;
	
	@Column(name = "rib_depart")
	private String ribDepart;
}
