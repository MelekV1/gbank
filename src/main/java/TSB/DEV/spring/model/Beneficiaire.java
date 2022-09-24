package TSB.DEV.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="beneficiaire")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Beneficiaire {
	
	@Id
	@Column (name="id")
	private long id;

	@Column (name="nom_ben")
	private String nomben;
	
	@Column (name="prenom_ben")
	private String prenomben;
	
	@Column (name="rib_beneficiaire")
	private String ribbeneficiaire;

}