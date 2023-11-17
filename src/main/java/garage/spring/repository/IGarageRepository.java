package garage.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import garage.spring.entities.GarageEntity;

public interface IGarageRepository extends JpaRepository<GarageEntity, Long>{

}
