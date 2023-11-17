package garage.spring.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import garage.spring.entities.CollaborateurEntity;

public interface ICollaborateurService  {
	public CollaborateurEntity findCollaborateurByUsername(String username);
	
	
}
