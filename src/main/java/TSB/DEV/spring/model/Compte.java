package TSB.DEV.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "compte")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numCompte;
	
	private String ribCompte;
	private double solde;
	private String ouverture;
	
    @ManyToOne
    private Client client ;
}
