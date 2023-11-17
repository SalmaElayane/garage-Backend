package garage.spring.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "collaborateur")

public class CollaborateurEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_collaborateur", nullable = false)
	private Long idCollaborateur;

	@Column(name = "username", nullable = false, length = 255)
	private String username;

	@Column(name = "password", nullable = false, length = 255)
	private String password;	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "collaborateurs_roles", joinColumns = @JoinColumn(name = "idCollaborateur"), inverseJoinColumns = @JoinColumn(name = "idRole"))
	private List<RoleEntity> roles = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "idGarage")
	private GarageEntity garage;


	}

