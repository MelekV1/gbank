package TSB.DEV.spring.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="virementmasses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@DiscriminatorValue("M")
public class VirementMasse extends Virement {
	
	@Column (name="details")
	private String details	;
	
}