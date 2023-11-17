package garage.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "garage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class GarageEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String nomGarage ;
	private String descriptions ;
	private String lieux ;
	
}