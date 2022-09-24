package TSB.DEV.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nom_clt")
	private String nom;

	@Column(name = "prenom_clt")
	private String prenom;
	
	@Column(name = "sexe_clt")
	private String sexe;
	
	@Column (name="email")
	private String email;
	
	@Column(name = "date_naissance")
	private String naissance;
	
	@Column(name = "profession_clt")
	private String profession;
	
	@Column(name = "type_clt")
	private String type;
	
	@Column(name = "etat_civil_clt")
	private String etatCivil;
	
	@Column(name = "num_tel")
	private String numTel;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn( name = "client_id", referencedColumnName = "id")
	List<Compte> comptes = new ArrayList<>();
}
