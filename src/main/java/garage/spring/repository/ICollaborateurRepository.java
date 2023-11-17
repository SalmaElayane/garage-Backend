package garage.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import garage.spring.entities.CollaborateurEntity;

@Repository
public interface ICollaborateurRepository extends JpaRepository<CollaborateurEntity,Long>{

	@Query("SELECT u FROM CollaborateurEntity u  WHERE u.username = :username")
	CollaborateurEntity findUserByUsername(@Param("username") String username);

}
