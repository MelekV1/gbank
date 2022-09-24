package TSB.DEV.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class ProprietaireCompte {
	private String ribCompte;	
	private double solde;
	private String ouverture;
    private Long idClient ;
}