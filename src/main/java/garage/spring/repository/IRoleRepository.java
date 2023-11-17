package garage.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import garage.spring.entities.RoleEntity;


public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {

}
